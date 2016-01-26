package com.ynyes.fayl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.service.TdArticleCategoryService;
import com.ynyes.fayl.service.TdArticleService;

/**
 * 进入首页的控制器
 * 
 * @author dengxiao
 *
 */

@Controller
@RequestMapping
public class TdIndexController {

	@Autowired
	private TdArticleCategoryService tdArticleCategoryService;
	
	@Autowired
	private TdArticleService tdArticleService;
	
	@RequestMapping
	public String index(HttpServletRequest req,ModelMap map){
		return "/client/index";
	}
}
