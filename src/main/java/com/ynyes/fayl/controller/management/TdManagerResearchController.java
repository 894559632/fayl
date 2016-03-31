package com.ynyes.fayl.controller.management;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.icu.text.SimpleDateFormat;
import com.ynyes.fayl.entity.TdGoods;
import com.ynyes.fayl.entity.TdJob;
import com.ynyes.fayl.entity.TdResearch;
import com.ynyes.fayl.service.TdArticleService;
import com.ynyes.fayl.service.TdBrandService;
import com.ynyes.fayl.service.TdCompanyInfoService;
import com.ynyes.fayl.service.TdGoodsParameterService;
import com.ynyes.fayl.service.TdGoodsService;
import com.ynyes.fayl.service.TdJobService;
import com.ynyes.fayl.service.TdManagerLogService;
import com.ynyes.fayl.service.TdParameterService;
import com.ynyes.fayl.service.TdPriceChangeLogService;
import com.ynyes.fayl.service.TdProductCategoryService;
import com.ynyes.fayl.service.TdProductService;
import com.ynyes.fayl.service.TdProviderService;
import com.ynyes.fayl.service.TdResearchService;
import com.ynyes.fayl.service.TdSampleCategoryService;
import com.ynyes.fayl.service.TdSampleService;
import com.ynyes.fayl.service.TdSiteService;
import com.ynyes.fayl.service.TdWarehouseService;
import com.ynyes.fayl.util.SiteMagConstant;

/**
 * 后台首页控制器
 * 
 * @author Sharon
 */

@Controller
@RequestMapping(value = "/Verwalter/research/")
public class TdManagerResearchController {

	@Autowired
	TdProductCategoryService tdProductCategoryService;

	@Autowired
	TdArticleService tdArticleService;

	@Autowired
	TdGoodsService tdGoodsService;

	@Autowired
	TdWarehouseService tdWarehouseService;

	@Autowired
	TdProviderService tdProviderService;

	@Autowired
	TdManagerLogService tdManagerLogService;

	@Autowired
	TdBrandService tdBrandService;

	@Autowired
	TdParameterService tdParameterService;

	@Autowired
	TdProductService tdProductService;

	@Autowired
	TdPriceChangeLogService tdPriceChangeLogService;

	@Autowired
	TdGoodsParameterService tdGoodsParameterService;

	@Autowired
	TdSiteService tdSiteService;

	@Autowired
	TdSampleService tdSampleService;

	@Autowired
	TdSampleCategoryService tdSampleCategoryService;

	@Autowired
	TdCompanyInfoService tdCompanyInfoService;

	@Autowired
	private TdJobService tdJobService;

	@Autowired
	private TdResearchService tdResearchService;

	@RequestMapping(value = "/list")
	public String goodsListPost(Integer page, Integer size, String saleType, String property, String __EVENTTARGET,
			String __EVENTARGUMENT, String __VIEWSTATE, String keywords, Long[] listId, Integer[] listChkId,
			Double[] listSortId, ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		if (null == page || page < 0) {
			page = 0;
		}

		if (null == size || size <= 0) {
			size = SiteMagConstant.pageSize;
		}

		if (null != keywords) {
			keywords = keywords.trim();
		}

		if (null != __EVENTTARGET) {
			switch (__EVENTTARGET) {
			case "lbtnViewTxt":
			case "lbtnViewImg":
				__VIEWSTATE = __EVENTTARGET;
				break;

			case "btnSave":
				btnSave(listId, listSortId, username);
				tdManagerLogService.addLog("edit", "用户修改招聘信息", req);
				break;

			case "btnDelete":
				btnDelete(listId, listChkId);
				tdManagerLogService.addLog("delete", "用户删除招聘信息", req);
				break;

			case "btnPage":
				if (null != __EVENTARGUMENT) {
					page = Integer.parseInt(__EVENTARGUMENT);
				}
				break;
			}
		}

		if (null != __EVENTTARGET && __EVENTTARGET.equalsIgnoreCase("lbtnViewTxt")
				|| null != __EVENTTARGET && __EVENTTARGET.equalsIgnoreCase("lbtnViewImg")) {
			__VIEWSTATE = __EVENTTARGET;
		}

		if (null != keywords && !"".equals(keywords)) {
			Page<TdResearch> goodsPage = tdResearchService.findByTitleContainingOrderBySortIdAsc(keywords, page, size);
			map.addAttribute("content_page", goodsPage);
		} else {
			Page<TdResearch> goodsPage = tdResearchService.findAll(page, size);
			map.addAttribute("content_page", goodsPage);
		}

		// 参数注回
		map.addAttribute("page", page);
		map.addAttribute("size", size);
		map.addAttribute("keywords", keywords);
		map.addAttribute("__EVENTTARGET", __EVENTTARGET);
		map.addAttribute("__EVENTARGUMENT", __EVENTARGUMENT);
		map.addAttribute("__VIEWSTATE", __VIEWSTATE);
		map.addAttribute("property", property);
		map.addAttribute("saleType", saleType);

		return "/site_mag/research_list";

	}

	@RequestMapping(value = "/edit")
	public String goodsEdit(Long id, String __EVENTTARGET, String __EVENTARGUMENT, String __VIEWSTATE, ModelMap map,
			HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		map.addAttribute("__EVENTTARGET", __EVENTTARGET);
		map.addAttribute("__EVENTARGUMENT", __EVENTARGUMENT);
		map.addAttribute("__VIEWSTATE", __VIEWSTATE);

		if (null != id) {
			TdResearch tdGoods = tdResearchService.findOne(id);
			map.addAttribute("goods", tdGoods);
		}

		return "/site_mag/research_edit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(TdResearch info, String[] hid_photo_name_show360, String __EVENTTARGET, String __EVENTARGUMENT,
			String __VIEWSTATE, String menuId, String channelId, ModelMap map, Boolean isIndexRecommend,
			Boolean isRecommendType, Boolean isHot, Boolean isNew, Boolean isSpecialPrice, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}
		
		String uris = parsePicUris(hid_photo_name_show360);

		String type = null;
		if (null == info.getId()) {
			type = "add";
		} else {
			type = "edit";
		}
		if (null != info && (null == info.getNumber() || "".equalsIgnoreCase(info.getNumber()))) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String dateFormat = sdf.format(new Date());
			Random random = new Random();
			int randomNumber = random.nextInt(900) + 100;
			String number = "FAYJ" + dateFormat + randomNumber;
			info.setNumber(number);
		}
		info.setImgUriList(uris);
		info = tdResearchService.save(info);
		tdManagerLogService.addLog(type, "用户修改公司研究案例信息", req);

		map.addAttribute("goods", info);

		return "redirect:/Verwalter/research/list?__EVENTTARGET=" + __EVENTTARGET + "&__EVENTARGUMENT="
				+ __EVENTARGUMENT + "&__VIEWSTATE=" + __VIEWSTATE;
	}

	@ModelAttribute
	public void getModel(@RequestParam(value = "id", required = false) Long id, Model model) {
		if (id != null) {
			TdGoods goods = tdGoodsService.findOne(id);
			model.addAttribute("tdGoods", goods);
		}
	}

	/**
	 * 修改商品
	 * 
	 * @param cid
	 * @param ids
	 * @param sortIds
	 * @param username
	 */
	private void btnSave(Long[] ids, Double[] sortIds, String username) {
		if (null == ids || null == sortIds || ids.length < 1 || sortIds.length < 1) {
			return;
		}

		for (int i = 0; i < ids.length; i++) {
			Long id = ids[i];

			TdJob goods = tdJobService.findOne(id);

			if (sortIds.length > i) {
				goods.setSortId(sortIds[i]);
				tdJobService.save(goods);
			}
		}
	}

	/**
	 * 删除商品
	 * 
	 * @param ids
	 * @param chkIds
	 */
	private void btnDelete(Long[] ids, Integer[] chkIds) {
		if (null == ids || null == chkIds || ids.length < 1 || chkIds.length < 1) {
			return;
		}

		for (int chkId : chkIds) {
			if (chkId >= 0 && ids.length > chkId) {
				Long id = ids[chkId];

				tdJobService.delete(id);
			}
		}
	}
	
	/**
	 * 图片地址字符串整理，多张图片用,隔开
	 * 
	 * @param params
	 * @return
	 */
	private String parsePicUris(String[] uris) {
		if (null == uris || 0 == uris.length) {
			return null;
		}

		String res = "";

		for (String item : uris) {
			String uri = item.substring(item.indexOf("|") + 1, item.indexOf("|", 2));

			if (null != uri) {
				res += uri;
				res += ",";
			}
		}

		return res;
	}

}
