package com.ynyes.fayl.controller.management;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.icu.text.SimpleDateFormat;
import com.ynyes.fayl.entity.TdArticle;
import com.ynyes.fayl.entity.TdArticleCategory;
import com.ynyes.fayl.service.TdArticleCategoryService;
import com.ynyes.fayl.service.TdArticleService;
import com.ynyes.fayl.service.TdBrandService;
import com.ynyes.fayl.service.TdGoodsService;
import com.ynyes.fayl.service.TdManagerLogService;
import com.ynyes.fayl.service.TdParameterCategoryService;
import com.ynyes.fayl.service.TdParameterService;
import com.ynyes.fayl.service.TdProductCategoryService;
import com.ynyes.fayl.service.TdProductService;
import com.ynyes.fayl.service.TdWarehouseService;

/**
 * 后台首页控制器
 * 
 * @author Sharon
 */

@Controller
@RequestMapping(value = "/Verwalter")
public class TdManagerEditController {

	@Autowired
	TdArticleCategoryService tdArticleCategoryService;

	@Autowired
	TdArticleService tdArticleService;

	@Autowired
	TdProductCategoryService tdProductCategoryService;

	@Autowired
	TdGoodsService tdGoodsService;

	@Autowired
	TdWarehouseService tdWarehouseService;

	@Autowired
	TdManagerLogService tdManagerLogService;

	@Autowired
	TdParameterCategoryService tdParameterCategoryService;

	@Autowired
	TdParameterService tdParameterService;

	@Autowired
	TdProductService tdProductService;

	@Autowired
	TdBrandService tdBrandService;

	@RequestMapping(value = "/category/edit")
	public String categoryEditDialog(Long cid, Long mid, Long id, Long sub, String __EVENTTARGET,
			String __EVENTARGUMENT, String __VIEWSTATE, ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		map.addAttribute("cid", cid);
		map.addAttribute("mid", mid);
		map.addAttribute("__EVENTTARGET", __EVENTTARGET);
		map.addAttribute("__EVENTARGUMENT", __EVENTARGUMENT);
		map.addAttribute("__VIEWSTATE", __VIEWSTATE);

		// if (null != cid && cid.equals(2L)) // 商品分类
		// {
		// map.addAttribute("category_list",
		// tdProductCategoryService.findAll());
		//
		// // 参数类型表
		// map.addAttribute("param_category_list",
		// tdParameterCategoryService.findAll());
		//
		// if (null != sub) // 添加子类
		// {
		// if (null != id)
		// {
		// map.addAttribute("fatherCat", tdProductCategoryService.findOne(id));
		// }
		// }
		// else
		// {
		// if (null != id)
		// {
		// map.addAttribute("cat", tdProductCategoryService.findOne(id));
		// }
		// }
		//
		// return "/site_mag/product_category_edit";
		// }
		// else
		{

			if (null != id) {
				if (null != sub) // 添加子类
				{
					map.addAttribute("fatherCat", tdArticleCategoryService.findOne(id));
				} else {
					map.addAttribute("cat", tdArticleCategoryService.findOne(id));
				}
			}

			return "/site_mag/article_category_edit";
		}
	}

	@RequestMapping(value = "/category/save", method = RequestMethod.POST)
	public String save(TdArticleCategory cat, String __EVENTTARGET, String __EVENTARGUMENT, String __VIEWSTATE,
			ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		if (null == cat.getId()) {
			tdManagerLogService.addLog("add", "用户修改文章分类", req);
		} else {
			tdManagerLogService.addLog("edit", "用户修改文章分类", req);
		}

		if (null != cat && null == cat.getId()) {
			// 生成唯一编码
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String dateFormat = sdf.format(new Date());
			Random random = new Random();
			int randomNumber = random.nextInt(900) + 100;
			String number = "WZFL" + dateFormat + randomNumber;
			cat.setNumber(number);
		}
		tdArticleCategoryService.save(cat);

		return "redirect:/Verwalter/category/list?" + "&__EVENTTARGET=" + __EVENTTARGET + "&__EVENTARGUMENT="
				+ __EVENTARGUMENT + "&__VIEWSTATE=" + __VIEWSTATE;
	}

	@RequestMapping(value = "/article/edit")
	public String articleEditDialog(Long cid, Long mid, Long pid, Long id, String __EVENTTARGET, String __EVENTARGUMENT,
			String __VIEWSTATE, ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		// 查询所有的文章分类
		List<TdArticleCategory> category_list = tdArticleCategoryService.findAll();
		map.addAttribute("category_list", category_list);

		if (null != id) {
			map.addAttribute("article", tdArticleService.findOne(id));
		}

		map.addAttribute("cid", cid);
		map.addAttribute("mid", mid);
		map.addAttribute("__EVENTTARGET", __EVENTTARGET);
		map.addAttribute("__EVENTARGUMENT", __EVENTARGUMENT);
		map.addAttribute("__VIEWSTATE", __VIEWSTATE);

		// if (null != cid)
		// {
		// if (cid.equals(5L)) // 产品
		// {
		// map.addAttribute("category_list",
		// tdProductCategoryService.findAll());
		// return "/site_mag/product_edit";
		// }
		// else if (cid.equals(2L)) // 商品
		// {
		// map.addAttribute("category_list",
		// tdProductCategoryService.findAll());
		//
		// if (null != id)
		// {
		// TdGoods tdGoods = tdGoodsService.findOne(id);
		//
		// if (null != tdGoods)
		// {
		// // 参数列表
		// TdProductCategory tpc =
		// tdProductCategoryService.findOne(tdGoods.getCategoryId());
		//
		// if (null != tpc && null != tpc.getParamCategoryId())
		// {
		// map.addAttribute("param_list",
		// tdParameterService.findByCategoryTreeContaining(tpc.getParamCategoryId()));
		// }
		//
		// // 查找产品列表
		// map.addAttribute("product_list",
		// tdProductService.findByProductCategoryTreeContaining(tdGoods.getCategoryId()));
		//
		// // 查找品牌
		// map.addAttribute("brand_list",
		// tdBrandService.findByProductCategoryTreeContaining(tdGoods.getCategoryId()));
		//
		// map.addAttribute("warehouse_list", tdWarehouseService.findAll());
		//
		// if (null != tdGoods.getProductId())
		// {
		// map.addAttribute("product",
		// tdProductService.findOne(tdGoods.getProductId()));
		// }
		//
		// map.addAttribute("goods", tdGoods);
		// }
		// }
		//
		// return "/site_mag/goods_edit";
		// }
		// }

		return "/site_mag/article_content_edit";
	}

	@RequestMapping(value = "/article/save", method = RequestMethod.POST)
	public String save(TdArticle article, String __EVENTTARGET, String __EVENTARGUMENT, String __VIEWSTATE,
			ModelMap map, HttpServletRequest req) {
		String username = (String) req.getSession().getAttribute("manager");
		if (null == username) {
			return "redirect:/Verwalter/login";
		}

		if (null != article && null == article.getNumber()) {
			// 以下代码生成文章编号
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String dateFormat = sdf.format(new Date());
			Random random = new Random();
			int randomNumber = random.nextInt(900) + 100;
			String number = "XW" + dateFormat + randomNumber;
			article.setNumber(number);
		}

		if (null != article && null == article.getCreateDate()) {
			article.setCreateDate(new Date());
		}

		if (null != article && null != article.getCategoryNumber()) {
			TdArticleCategory category = tdArticleCategoryService.findByNumber(article.getCategoryNumber());
			if (null != category) {
				article.setCategoryTitle(category.getTitle());
			}
		}

		String logType = null;
		if (null == article.getId()) {
			logType = "add";
		} else {
			logType = "edit";
		}

		tdArticleService.save(article);

		tdManagerLogService.addLog(logType, "用户修改文章", req);

		return "redirect:/Verwalter/content/list?" + "&__EVENTTARGET=" + __EVENTTARGET + "&__EVENTARGUMENT="
				+ __EVENTARGUMENT + "&__VIEWSTATE=" + __VIEWSTATE;
	}

}
