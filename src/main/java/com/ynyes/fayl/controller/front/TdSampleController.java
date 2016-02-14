package com.ynyes.fayl.controller.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.entity.TdSample;
import com.ynyes.fayl.entity.TdSampleCategory;
import com.ynyes.fayl.service.TdCommonService;
import com.ynyes.fayl.service.TdSampleCategoryService;
import com.ynyes.fayl.service.TdSampleService;
import com.ynyes.fayl.util.ClientConstant;

/**
 * 所有有关案例的控制器
 * 
 * @author DengXiao
 *
 */

@Controller
@RequestMapping(value = "/sample")
public class TdSampleController {

	@Autowired
	private TdSampleCategoryService tdSampleCategoryService;

	@Autowired
	private TdSampleService tdSampleService;
	
	@Autowired
	private TdCommonService tdCommonService;

	/**
	 * 跳转到经典案例的控制器
	 * 
	 * @author DengXiao
	 */
	@RequestMapping(value = "/category/{number}")
	public String sampleCategory(HttpServletRequest req, ModelMap map, @PathVariable String number, Integer page) {
		// 获取所有的案例分类
		List<TdSampleCategory> sample_category_list = tdSampleCategoryService.findAll();
		map.addAttribute("sample_category_list", sample_category_list);
		// 查找指定编号的分类
		TdSampleCategory sampleCategory = tdSampleCategoryService.findByNumber(number);
		map.addAttribute("sample_category", sampleCategory);
		map.addAttribute("number", number);
		// 初始化page参数
		if (null == page || page < 0) {
			page = 0;
		}
		// 根据指定的分类编号查找其下所有的案例（分页）
		Page<TdSample> sample_page = tdSampleService.findByCategoryNumberOrderBySortIdAsc(number, page,
				ClientConstant.pageSize);
		// 如果页数超过了总页数，则重新查询一次
		if (null != sample_page) {
			// 获取总页数
			int totalPages = sample_page.getTotalPages();
			// 如果当前页数大于了总页数—1，则按照最大页数重新查询一次
			if (page > totalPages - 1) {
				page = totalPages - 1;
				sample_page = tdSampleService.findByCategoryNumberOrderBySortIdAsc(number, page,
						ClientConstant.pageSize);
			}
		}
		map.addAttribute("sample_page", sample_page);
		map.addAttribute("page", page);
		map.addAttribute("number", number);
		tdCommonService.setHeader(req, map);
		return "/client/sample_list";
	}

	/**
	 * 跳转到案例详情的控制器
	 * 
	 * @author DengXiao
	 */
	@RequestMapping(value = "/detail/{number}")
	public String sampleDetail(HttpServletRequest req, ModelMap map, @PathVariable String number) {
		// 查找指定编码的案例
		TdSample sample = tdSampleService.findByNumber(number);
		map.addAttribute("sample", sample);
		// 查找当前分类下的所有案例（两种方式：1. 从session中取出；2. 从数据库中取出）
		if (null != sample && null != sample.getCategoryNumber()) {
			@SuppressWarnings("unchecked")
			List<TdSample> sample_list = (List<TdSample>) req.getSession()
					.getAttribute("sample_list" + sample.getCategoryNumber());
			if (null == sample_list) {
				sample_list = tdSampleService.findByCategoryNumberOrderBySortIdAsc(sample.getCategoryNumber());
				// 查找过一次之后将指定分类下的样例集合存储到session中，避免重复查询
				req.getSession().setAttribute("sample_list" + sample.getCategoryNumber(), sample_list);
			}
			if (null != sample_list && sample_list.size() > 0) {
				int size = sample_list.size();
				// 遍历集合，查找上一个案例和下一个案例
				for (int i = 0; i < sample_list.size(); i++) {
					TdSample tdSample = sample_list.get(i);
					// 根据样例的编号查找到指定的样例
					if (null != tdSample && null != tdSample.getNumber() && tdSample.getNumber().equals(number)) {
						// 开始查找上一个样例（如果是第一个样例，那么上一个就是无）
						if (0 != i) {
							map.addAttribute("pre_sample", sample_list.get(i - 1));
						}

						// 开始查找下一个（如果是最后一个，则下一个就是无）
						if (size - 1 != i) {
							map.addAttribute("next_sample", sample_list.get(i + 1));
						}
					}
				}
			}
		}
		tdCommonService.setHeader(req, map);
		return "/front/sample_detail";
	}
}
