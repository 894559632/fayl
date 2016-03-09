package com.ynyes.fayl.controller.touch;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.entity.TdSample;
import com.ynyes.fayl.entity.TdSampleCategory;
import com.ynyes.fayl.service.TdCommonService;
import com.ynyes.fayl.service.TdSampleCategoryService;
import com.ynyes.fayl.service.TdSampleService;

/**
 * 有关案例的控制器
 * 
 * @author DengXiao
 */
@Controller
@RequestMapping(value = "/touch/sample")
public class TdTouchSampleController {

	@Autowired
	private TdSampleCategoryService tdSampleCategoryService;

	@Autowired
	private TdSampleService tdSampleService;

	@Autowired
	private TdCommonService tdCommonService;

	@RequestMapping(value = "/list")
	public String sampleList(HttpServletRequest req, ModelMap map, String number) {
		// 查询出所有的案例分类
		List<TdSampleCategory> sample_category_list = tdSampleCategoryService.findAll();
		map.addAttribute("sample_category_list", sample_category_list);

		// 根据指定的分类编号查找分类
		TdSampleCategory sample_category = tdSampleCategoryService.findByNumber(number);
		if (null != sample_category && null != sample_category.getNumber()) {
			List<TdSample> sample_list = tdSampleService
					.findByCategoryNumberOrderBySortIdAsc(sample_category.getNumber());
			map.addAttribute("category", sample_category);
			map.addAttribute("sample_list", sample_list);
		} else {
			// 遍历所有的案例分类，使用第一个作为默认分类
			if (null != sample_category_list && sample_category_list.size() > 0) {
				TdSampleCategory category = sample_category_list.get(0);
				if (null != category && null != category.getNumber()) {
					List<TdSample> sample_list = tdSampleService
							.findByCategoryNumberOrderBySortIdAsc(category.getNumber());
					map.addAttribute("category", category);
					map.addAttribute("sample_list", sample_list);
				}
			}
		}
		tdCommonService.setHeader(req, map);
		return "/touch/sample_list";
	}

	@RequestMapping(value = "/detail")
	public String sampleDetail(HttpServletRequest req, ModelMap map, String number) {
		// 查询指定编号的案例
		TdSample sample = tdSampleService.findByNumber(number);
		map.addAttribute("sample", sample);
		tdCommonService.setHeader(req, map);
		return "/touch/sample_detail";
	}
}
