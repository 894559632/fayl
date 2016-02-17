package com.ynyes.fayl.controller.management;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ynyes.fayl.entity.TdArticle;
import com.ynyes.fayl.entity.TdArticleCategory;
import com.ynyes.fayl.service.TdArticleCategoryService;
import com.ynyes.fayl.service.TdArticleService;
import com.ynyes.fayl.service.TdGoodsService;
import com.ynyes.fayl.service.TdManagerLogService;
import com.ynyes.fayl.service.TdProductCategoryService;
import com.ynyes.fayl.util.SiteMagConstant;

/**
 * 后台首页控制器
 * 
 * @author Sharon
 */

@Controller
@RequestMapping(value = "/Verwalter")
public class TdManagerListController {

	@Autowired
	TdArticleCategoryService tdArticleCategoryService;

	@Autowired
	TdArticleService tdArticleService;

	@Autowired
	TdProductCategoryService tdProductCategoryService;

	@Autowired
	TdGoodsService tdGoodsService;

	@Autowired
	TdManagerLogService tdManagerLogService;

	@RequestMapping(value = "/category/list")
	public String categoryList(Long cid, Long mid, String __EVENTTARGET, String __EVENTARGUMENT, String __VIEWSTATE,
			Long[] listId, Integer[] listChkId, Double[] listSortId, ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		List<TdArticleCategory> category_list = tdArticleCategoryService.findAllOrderBySortIdAsc();
		map.addAttribute("category_list", category_list);

		// 参数注回
		map.addAttribute("cid", cid);
		map.addAttribute("mid", mid);
		map.addAttribute("__EVENTTARGET", __EVENTTARGET);
		map.addAttribute("__EVENTARGUMENT", __EVENTARGUMENT);
		map.addAttribute("__VIEWSTATE", __VIEWSTATE);

		return "/site_mag/category_list";
	}

	@RequestMapping(value = "/category/list", method = RequestMethod.POST)
	public String categoryPostList(Long cid, Long mid, String __EVENTTARGET, String __EVENTARGUMENT, String __VIEWSTATE,
			Long[] listId, Integer[] listChkId, Double[] listSortId, ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		if (null != __EVENTTARGET) {
			switch (__EVENTTARGET) {
			case "btnSave":
				if (cid.equals(1L)) // 文章
				{
					articleCategoryBtnSave(listId, listSortId);
					tdManagerLogService.addLog("edit", "用户修改文章分类", req);
				}
				
				break;

			case "btnDelete":
				if (cid.equals(1L)) // 文章
				{
					articleCategoryBtnDelete(listId, listChkId);
					tdManagerLogService.addLog("delete", "用户删除文章分类", req);
				}

				break;
			}
		}
		
		List<TdArticleCategory> category_list = tdArticleCategoryService.findAllOrderBySortIdAsc();
		map.addAttribute("category_list", category_list);

		// 参数注回
		map.addAttribute("cid", cid);
		map.addAttribute("mid", mid);
		map.addAttribute("__EVENTTARGET", __EVENTTARGET);
		map.addAttribute("__EVENTARGUMENT", __EVENTARGUMENT);
		map.addAttribute("__VIEWSTATE", __VIEWSTATE);

		return "/site_mag/category_list";
	}

	@RequestMapping(value = "/content/list")
	public String contentList(Long cid, Long mid, Integer page, Integer size, String categoryNumber, String property,
			String __EVENTTARGET, String __EVENTARGUMENT, String __VIEWSTATE, String keywords, Long[] listId,
			Integer[] listChkId, Double[] listSortId, ModelMap map, HttpServletRequest req) {
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

		// 查询所有的文章分类
		List<TdArticleCategory> category_list = tdArticleCategoryService.findAll();
		map.addAttribute("category_list", category_list);

		// 查询所有的文章，按照生成时间反序排序（分页）
		if (null == categoryNumber) {
			Page<TdArticle> content_page = tdArticleService.findAllOrderByCreateTime(page, size);
			map.addAttribute("content_page", content_page);
		} else {
			Page<TdArticle> content_page = tdArticleService.findByCategoryNumberOrderByCreateDateDesc(categoryNumber,
					page, size);
			map.addAttribute("content_page", content_page);
		}

		// 参数注回
		map.addAttribute("cid", cid);
		map.addAttribute("mid", mid);
		map.addAttribute("page", page);
		map.addAttribute("size", size);
		map.addAttribute("__EVENTTARGET", __EVENTTARGET);
		map.addAttribute("__EVENTARGUMENT", __EVENTARGUMENT);
		map.addAttribute("__VIEWSTATE", __VIEWSTATE);
		map.addAttribute("categoryNumber", categoryNumber);
		map.addAttribute("property", property);

		// 文字列表模式
		if (null != __VIEWSTATE && __VIEWSTATE.equals("lbtnViewTxt")) {
			if (null != cid && cid.equals(2L)) // 商品
			{
				return "/site_mag/goods_txt_list";
			} else {
				return "/site_mag/content_txt_list";
			}
		}

		// 图片列表模式
		if (null != cid && cid.equals(2L)) // 商品
		{
			return "/site_mag/goods_pic_list";
		} else {
			return "/site_mag/content_txt_list";
		}
	}

	@RequestMapping(value = "/content/list", method = RequestMethod.POST)
	public String contentListP(Long cid, Long mid, Integer page, Integer size, String categoryNumber, String property,
			String __EVENTTARGET, String __EVENTARGUMENT, String __VIEWSTATE, String txtKeywords, Long[] listId,
			Integer[] listChkId, Double[] listSortId, ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		if (null != __EVENTTARGET) {
			switch (__EVENTTARGET) {
			case "btnSave":
				tdArticleBtnSave(listId, listSortId);

				break;

			case "btnDelete":
				tdArticleBtnDelete(listId, listChkId);

				break;
			}
		}

		if (null == page || page < 0) {
			page = 0;
		}

		if (null == size || size <= 0) {
			size = SiteMagConstant.pageSize;
		}

		if ("btnPage".equals(__EVENTTARGET)) {
			page = Integer.parseInt(__EVENTARGUMENT);
		}

		// 查询所有的文章分类
		List<TdArticleCategory> category_list = tdArticleCategoryService.findAll();
		map.addAttribute("category_list", category_list);

		if (!(null == categoryNumber || "".equals(categoryNumber))) {
			if (null == txtKeywords || "".equals(txtKeywords)) {
				Page<TdArticle> content_page = tdArticleService
						.findByCategoryNumberOrderByCreateDateDesc(categoryNumber, page, size);
				map.addAttribute("content_page", content_page);
			} else {
				Page<TdArticle> content_page = tdArticleService
						.findByCategoryNumberAndTitleContainingOrderByCreateDateDesc(categoryNumber, txtKeywords, page,
								size);
				map.addAttribute("content_page", content_page);
			}
		} else {
			if (null == txtKeywords || "".equals(txtKeywords)) {
				Page<TdArticle> content_page = tdArticleService.findAll(page, size);
				map.addAttribute("content_page", content_page);
			} else {
				Page<TdArticle> content_page = tdArticleService.findByTitleContainingOrderByCreateDateDesc(txtKeywords,
						page, size);
				map.addAttribute("content_page", content_page);
			}
		}


		// 参数注回
		map.addAttribute("keywords", txtKeywords);
		map.addAttribute("cid", cid);
		map.addAttribute("mid", mid);
		map.addAttribute("page", page);
		map.addAttribute("size", size);
		map.addAttribute("__EVENTTARGET", __EVENTTARGET);
		map.addAttribute("__EVENTARGUMENT", __EVENTARGUMENT);
		map.addAttribute("__VIEWSTATE", __VIEWSTATE);
		map.addAttribute("categoryNumber", categoryNumber);
		map.addAttribute("property", property);

		// 文字列表模式
		if (null != __VIEWSTATE && __VIEWSTATE.equals("lbtnViewTxt")) {
			if (null != cid && cid.equals(2L)) // 商品
			{
				return "/site_mag/goods_txt_list";
			} else {
				return "/site_mag/content_txt_list";
			}
		}

		// 图片列表模式
		if (null != cid && cid.equals(2L)) // 商品
		{
			return "/site_mag/goods_pic_list";
		} else {
			return "/site_mag/content_txt_list";
		}
	}

	/**
	 * 保存类型排序ID
	 * 
	 * @param ids
	 * @param chkIds
	 * @param sortIds
	 */
	private void articleCategoryBtnSave(Long[] ids, Double[] sortIds) {
		if (null == ids || null == sortIds || ids.length < 1 || sortIds.length < 1) {
			return;
		}

		for (int i = 0; i < ids.length; i++) {
			Long id = ids[i];
			TdArticleCategory category = tdArticleCategoryService.findOne(id);

			if (sortIds.length > i) {
				category.setSortId(sortIds[i]);
				tdArticleCategoryService.save(category);
			}
		}
	}

	// private void productCategoryBtnSave(Long[] ids, Long[] sortIds)
	// {
	// if (null == ids || null == sortIds
	// || ids.length < 1 || sortIds.length < 1)
	// {
	// return;
	// }
	//
	// for (int i = 0; i < ids.length; i++)
	// {
	// Long id = ids[i];
	// TdProductCategory category = tdProductCategoryService.findOne(id);
	//
	// if (sortIds.length > i)
	// {
	// category.setSortId(sortIds[i]);
	// tdProductCategoryService.save(category);
	// }
	// }
	// }

	/**
	 * 删除类型
	 * 
	 * @param ids
	 * @param chkIds
	 * @param sortIds
	 */
	private void articleCategoryBtnDelete(Long[] ids, Integer[] chkIds) {
		if (null == ids || null == chkIds || ids.length < 1 || chkIds.length < 1) {
			return;
		}

		for (int chkId : chkIds) {
			if (chkId >= 0 && ids.length > chkId) {
				Long id = ids[chkId];

				tdArticleCategoryService.delete(id);
			}
		}
	}

	private void tdArticleBtnSave(Long[] ids, Double[] sortIds) {
		if (null == ids || null == sortIds || ids.length < 1 || sortIds.length < 1) {
			return;
		}

		for (int i = 0; i < ids.length; i++) {
			Long id = ids[i];
			TdArticle category = tdArticleService.findOne(id);

			if (sortIds.length > i) {
				category.setSortId(sortIds[i]);
				tdArticleService.save(category);
			}
		}
	}

	private void tdArticleBtnDelete(Long[] ids, Integer[] chkIds) {
		if (null == ids || null == chkIds || ids.length < 1 || chkIds.length < 1) {
			return;
		}

		for (int chkId : chkIds) {
			if (chkId >= 0 && ids.length > chkId) {
				Long id = ids[chkId];

				tdArticleService.delete(id);
			}
		}
	}
}
