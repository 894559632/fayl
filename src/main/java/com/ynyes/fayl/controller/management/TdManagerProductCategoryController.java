package com.ynyes.fayl.controller.management;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.icu.text.SimpleDateFormat;
import com.ynyes.fayl.entity.TdSampleCategory;
import com.ynyes.fayl.service.TdManagerLogService;
import com.ynyes.fayl.service.TdParameterCategoryService;
import com.ynyes.fayl.service.TdProductCategoryService;
import com.ynyes.fayl.service.TdSampleCategoryService;

/**
 * 后台产品控制器
 * 
 * @author Sharon
 */

@Controller
@RequestMapping(value = "/Verwalter/product/category")
public class TdManagerProductCategoryController {

	@Autowired
	TdProductCategoryService tdProductCategoryService;

	@Autowired
	TdManagerLogService tdManagerLogService;

	@Autowired
	TdParameterCategoryService tdParameterCategoryService;

	@Autowired
	TdSampleCategoryService tdSampleCategoryService;

	@RequestMapping(value = "/list")
	public String categoryList(String __EVENTTARGET, String __EVENTARGUMENT, String __VIEWSTATE, Long[] listId,
			Integer[] listChkId, Double[] listSortId, ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		if (null != __EVENTTARGET) {
			switch (__EVENTTARGET) {
			case "btnSave":
				productCategoryBtnSave(listId, listSortId);

				break;

			case "btnDelete":
				productCategoryBtnDelete(listId, listChkId);

				break;
			}
		}

		map.addAttribute("category_list", tdSampleCategoryService.findAll());

		// 参数注回
		map.addAttribute("__EVENTTARGET", __EVENTTARGET);
		map.addAttribute("__EVENTARGUMENT", __EVENTARGUMENT);
		map.addAttribute("__VIEWSTATE", __VIEWSTATE);

		return "/site_mag/product_category_list";
	}

	@RequestMapping(value = "/edit")
	public String categoryEditDialog(Long id, Long sub, String __EVENTTARGET, String __EVENTARGUMENT,
			String __VIEWSTATE, ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		map.addAttribute("__EVENTTARGET", __EVENTTARGET);
		map.addAttribute("__EVENTARGUMENT", __EVENTARGUMENT);
		map.addAttribute("__VIEWSTATE", __VIEWSTATE);

		map.addAttribute("category_list", tdSampleCategoryService.findAll());

		map.addAttribute("cat", tdSampleCategoryService.findOne(id));

		return "/site_mag/product_category_edit";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(TdSampleCategory cat, String __EVENTTARGET, String __EVENTARGUMENT, String __VIEWSTATE,
			ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		if (null == cat.getId()) {
			tdManagerLogService.addLog("add", "用户修改案例分类", req);
		} else {
			tdManagerLogService.addLog("edit", "用户修改案例分类", req);
		}

		// 如果没有编号，就自动生成一个
		if (null != cat && (null == cat.getNumber() || "".equals(cat.getNumber()))) {
			// 生成编码
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String dateFormat = sdf.format(new Date());
			Random random = new Random();
			int randomNumber = random.nextInt(900) + 100;
			String number = "ALFL" + dateFormat + randomNumber;
			cat.setNumber(number);
		}

		tdSampleCategoryService.save(cat);

		return "redirect:/Verwalter/product/category/list";
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> validateForm(String param, Long id) {
		Map<String, String> res = new HashMap<String, String>();

		res.put("status", "n");

		if (null == param || param.isEmpty()) {
			res.put("info", "该字段不能为空");
			return res;
		}

		// if (null == id) // 新增分类，查找所有
		// {
		// if (null != tdProductCategoryService.findByTitle(param)) {
		// res.put("info", "已存在同名分类");
		// return res;
		// }
		// } else // 修改，查找除当前ID的所有
		// {
		// if (null != tdProductCategoryService.findByTitleAndIdNot(param, id))
		// {
		// res.put("info", "已存在同名分类");
		// return res;
		// }
		// }

		res.put("status", "y");

		return res;
	}

	private void productCategoryBtnSave(Long[] ids, Double[] sortIds) {
		if (null == ids || null == sortIds || ids.length < 1 || sortIds.length < 1) {
			return;
		}

		for (int i = 0; i < ids.length; i++) {
			Long id = ids[i];
			TdSampleCategory category = tdSampleCategoryService.findOne(id);

			if (sortIds.length > i) {
				category.setSortId(sortIds[i]);
				tdSampleCategoryService.save(category);
			}
		}
	}

	private void productCategoryBtnDelete(Long[] ids, Integer[] chkIds) {
		if (null == ids || null == chkIds || ids.length < 1 || chkIds.length < 1) {
			return;
		}

		for (int chkId : chkIds) {
			if (chkId >= 0 && ids.length > chkId) {
				Long id = ids[chkId];

				tdSampleCategoryService.delete(id);
			}
		}
	}
}
