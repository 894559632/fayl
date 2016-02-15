package com.ynyes.fayl.controller.touch;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.entity.TdArticle;
import com.ynyes.fayl.entity.TdArticleCategory;
import com.ynyes.fayl.service.TdArticleCategoryService;
import com.ynyes.fayl.service.TdArticleService;
import com.ynyes.fayl.service.TdCommonService;

@Controller
@RequestMapping(value = "/touch/article")
public class TdTouchArticleController {

	@Autowired
	private TdCommonService tdCommonService;

	@Autowired
	private TdArticleCategoryService tdArticleCategoryService;

	@Autowired
	private TdArticleService tdArticleService;

	@RequestMapping(value = "/list")
	public String articleList(HttpServletRequest req, ModelMap map, String number) {
		// 查找指定的分类
		TdArticleCategory category = tdArticleCategoryService.findByNumber(number);
		map.addAttribute("category", category);
		// 根据指定的分类编号查找文章列表
		List<TdArticle> article_list = tdArticleService.findByCategoryNumberOrderByCreateDateDesc(number);
		map.addAttribute("article_list", article_list);
		tdCommonService.setHeader(req, map);
		return "/touh/article_list";
	}

	@RequestMapping(value = "/detail/{number}")
	public String articleDetail(HttpServletRequest req, ModelMap map, @PathVariable String number) {
		TdArticle article = tdArticleService.findByNumber(number);
		map.addAttribute("article", article);
		tdCommonService.setHeader(req, map);
		return "/touch/article_detail";
	}

}
