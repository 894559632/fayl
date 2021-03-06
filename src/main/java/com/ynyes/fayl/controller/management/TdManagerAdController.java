package com.ynyes.fayl.controller.management;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.icu.text.SimpleDateFormat;
import com.ynyes.fayl.entity.TdAd;
import com.ynyes.fayl.service.TdAdService;
import com.ynyes.fayl.service.TdAdTypeService;
import com.ynyes.fayl.service.TdManagerLogService;
import com.ynyes.fayl.service.TdResearchService;
import com.ynyes.fayl.util.SiteMagConstant;

/**
 * 后台广告管理控制器
 * 
 * @author Sharon
 */

@Controller
@RequestMapping(value = "/Verwalter/ad")
public class TdManagerAdController {

	@Autowired
	TdAdService tdAdService;

	@Autowired
	TdAdTypeService tdAdTypeService;

	@Autowired
	TdManagerLogService tdManagerLogService;
	
	@Autowired
	TdResearchService tdResearchService;

	@RequestMapping(value = "/list")
	public String setting(Integer page, Integer size, String __EVENTTARGET, String __EVENTARGUMENT, String __VIEWSTATE,
			Long[] listId, Integer[] listChkId, Double[] listSortId, ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		if (null != __EVENTTARGET) {
			if (__EVENTTARGET.equalsIgnoreCase("btnDelete")) {
				btnDelete(listId, listChkId);
				tdManagerLogService.addLog("delete", "用户删除广告", req);
			} else if (__EVENTTARGET.equalsIgnoreCase("btnSave")) {
				btnSave(listId, listSortId);
				tdManagerLogService.addLog("edit", "用户修改广告", req);
			} else if (__EVENTTARGET.equalsIgnoreCase("btnPage")) {
				if (null != __EVENTARGUMENT) {
					page = Integer.parseInt(__EVENTARGUMENT);
				}
			}
		}

		if (null == page || page < 0) {
			page = 0;
		}

		if (null == size || size <= 0) {
			size = SiteMagConstant.pageSize;
			;
		}

		map.addAttribute("page", page);
		map.addAttribute("size", size);
		map.addAttribute("__EVENTTARGET", __EVENTTARGET);
		map.addAttribute("__EVENTARGUMENT", __EVENTARGUMENT);
		map.addAttribute("__VIEWSTATE", __VIEWSTATE);

		map.addAttribute("ad_page", tdAdService.findAll(page, size));

		return "/site_mag/ad_list";
	}

	@RequestMapping(value = "/edit")
	public String orderEdit(Long id, String __VIEWSTATE, ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		map.addAttribute("__VIEWSTATE", __VIEWSTATE);

		map.addAttribute("ad_type_list", tdAdTypeService.findAll());
		//提供所有的泛奥研究
		map.addAttribute("research_list", tdResearchService.findAll());

		if (null != id) {
			map.addAttribute("ad", tdAdService.findOne(id));
		}
		return "/site_mag/ad_edit";
	}

	@RequestMapping(value = "/save")
	public String orderEdit(TdAd tdAd, String __VIEWSTATE, ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		map.addAttribute("__VIEWSTATE", __VIEWSTATE);

		String type = null;

		if (null == tdAd.getId()) {
			type = "add";
		} else {
			type = "edit";
		}

		if (null != tdAd && (null == tdAd.getNumber() || "".equals(tdAd.getNumber()))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String dateFormat = sdf.format(new Date());
			Random random = new Random();
			int randomNumber = random.nextInt(900) + 100;
			String number = "GGNR" + dateFormat + randomNumber;
			tdAd.setNumber(number);
		}

		tdAdService.save(tdAd);

		tdManagerLogService.addLog(type, "用户修改广告", req);

		return "redirect:/Verwalter/ad/list";
	}

	@ModelAttribute
	public void getModel(@RequestParam(value = "id", required = false) Long id, Model model) {
		if (null != id) {
			model.addAttribute("tdAd", tdAdService.findOne(id));
		}
	}

	private void btnSave(Long[] ids, Double[] sortIds) {
		if (null == ids || null == sortIds || ids.length < 1 || sortIds.length < 1) {
			return;
		}

		for (int i = 0; i < ids.length; i++) {
			Long id = ids[i];

			TdAd e = tdAdService.findOne(id);

			if (null != e) {
				if (sortIds.length > i) {
					e.setSortId(sortIds[i]);
					tdAdService.save(e);
				}
			}
		}
	}

	private void btnDelete(Long[] ids, Integer[] chkIds) {
		if (null == ids || null == chkIds || ids.length < 1 || chkIds.length < 1) {
			return;
		}

		for (int chkId : chkIds) {
			if (chkId >= 0 && ids.length > chkId) {
				Long id = ids[chkId];

				tdAdService.delete(id);
			}
		}
	}
}
