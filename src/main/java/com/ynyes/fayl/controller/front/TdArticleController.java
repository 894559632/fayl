package com.ynyes.fayl.controller.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.entity.TdArticle;
import com.ynyes.fayl.entity.TdArticleCategory;
import com.ynyes.fayl.service.TdArticleCategoryService;
import com.ynyes.fayl.service.TdArticleService;
import com.ynyes.fayl.service.TdCommonService;
import com.ynyes.fayl.util.ClientConstant;

/**
 * 所有跟新闻相关的控制器
 * 
 * @author DengXiao
 */

@Controller
@RequestMapping(value = "/article")
public class TdArticleController {

	@Autowired
	private TdArticleService tdArticleService;

	@Autowired
	private TdArticleCategoryService tdArticleCategoryService;

	@Autowired
	private TdCommonService tdCommonService;

	/**
	 * 跳转到分类列表页的方法
	 * 
	 * @author DengXiao
	 */
	@RequestMapping(value = "/category/{number}")
	public String articleList(HttpServletRequest req, ModelMap map, @PathVariable String number, Integer page) {
		TdArticleCategory article_category = null;
		List<TdArticleCategory> all_article_category = tdArticleCategoryService.findAll();
		map.addAttribute("all_article_category", all_article_category);
		if (null == number || "default".equals(number)) {
			// 如果没有文章分类的编号，则查找所有的分类，默认第一个
			for (TdArticleCategory category : all_article_category) {
				if (null != category) {
					article_category = category;
					break;
				}
			}
		} else {
			article_category = tdArticleCategoryService.findByNumber(number);
		}

		if (null != article_category) {
			map.addAttribute("article_category", article_category);
			if (null == page || page < 0) {
				page = 0;
			}

			// 根据文章分类查找其下是所有的文章
			Page<TdArticle> article_page = tdArticleService.findByCategoryNumberOrderByCreateDateDesc(number, page,
					ClientConstant.pageSize);
			// 判断当前页数是否大于了最大页数-1，如果是则按照最大页数-1为page重新查询
			if (null != article_page && page > article_page.getTotalPages() - 1) {
				article_page = tdArticleService.findByCategoryNumberOrderByCreateDateDesc(number,
						article_page.getTotalPages() - 1, ClientConstant.pageSize);
			}
			map.addAttribute("article_page", article_page);
		}
		map.addAttribute("number", number);
		map.addAttribute("page", page);
		tdCommonService.setHeader(req, map);
		return "/front/article_list";
	}

	/**
	 * 跳转到文章详情页的控制器
	 * 
	 * @author DengXiao
	 */
	@RequestMapping(value = "/detail/{number}")
	public String articleDetail(HttpServletRequest req, ModelMap map, @PathVariable String number) {
		// 根据编号获取指定的文章
		TdArticle article = tdArticleService.findByNumber(number);
		map.addAttribute("article", article);
		if (null != article && null != article.getCategoryNumber()) {
			// 获取到指定文章的分类编号
			String categoryNumber = article.getCategoryNumber();
			TdArticleCategory category = tdArticleCategoryService.findByNumber(categoryNumber);
			map.addAttribute("category", category);
			// 从session中获取指定分类下的所有文章
			@SuppressWarnings("unchecked")
			List<TdArticle> article_list = (List<TdArticle>) req.getSession()
					.getAttribute("article_list" + categoryNumber);
			// 如果从session中没有取得文章集合，则从数据库中查询
			if (null == article_list) {
				article_list = tdArticleService.findByCategoryNumberOrderByCreateDateDesc(categoryNumber);
				req.getSession().setAttribute("article_list" + categoryNumber, article_list);
			}
			// 遍历集合，查找上一篇文章和下一篇文章
			if (null != article_list && article_list.size() > 0) {
				for (int i = 0; i < article_list.size(); i++) {
					TdArticle tdArticle = article_list.get(i);
					if (null != tdArticle && null != tdArticle.getNumber() && tdArticle.getAuthor().equals(number)) {
						// 开始查找上一篇文章，如果这是第一篇文章，则上一篇为无
						if (0 != i) {
							map.addAttribute("pre_article", article_list.get(i - 1));
						}

						// 开始查找下一篇文章，如果这是最后一篇文章，则下一篇为无
						if (article_list.size() - 1 != i) {
							map.addAttribute("next_article", article_list.get(i + 1));
						}
					}
				}
			}

		}
		tdCommonService.setHeader(req, map);
		return "/front/article_detail";
	}
}
