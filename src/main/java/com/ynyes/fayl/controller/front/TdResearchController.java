package com.ynyes.fayl.controller.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.entity.TdResearch;
import com.ynyes.fayl.service.TdCommonService;
import com.ynyes.fayl.service.TdResearchService;

/**
 * 有关泛奥研究的控制器
 * 
 * @author DengXiao
 */
@Controller
@RequestMapping(value = "/research")
public class TdResearchController {

	@Autowired
	private TdResearchService tdResearchService;

	@Autowired
	private TdCommonService tdCommonService;

	@RequestMapping(value = "/list")
	public String researchList(HttpServletRequest req, ModelMap map, Integer page) {
		if (null == page || page < 0) {
			page = 0;
		}
		// 查找所有的研究（分页）
		Page<TdResearch> research_page = tdResearchService.findAll(page, 6);
		map.addAttribute("research_page", research_page);
		tdCommonService.setHeader(req, map);
		map.addAttribute("page", page);
		return "/front/research";
	}

	@RequestMapping(value = "/detail/{number}")
	public String researchDetail(HttpServletRequest req, ModelMap map, @PathVariable String number) {
		TdResearch research = tdResearchService.findByNumber(number);
		map.addAttribute("research", research);
		// 两种方式获取所有的泛奥研究：1. 从session中取出；2. 从数据库中读取
		@SuppressWarnings("unchecked")
		List<TdResearch> research_list = (List<TdResearch>) req.getSession().getAttribute("research_list");
		if (null == research_list) {
			research_list = tdResearchService.findAll();
			// 查找过一次之后就把所有的泛奥研究存放到session中，以避免二次查询
			req.getSession().setAttribute("research_list", research_list);
		}
		if (null != research_list && research_list.size() > 0) {
			int size = research_list.size();
			for (int i = 0; i < research_list.size(); i++) {
				TdResearch tdResearch = research_list.get(i);
				if (null != tdResearch && null != tdResearch.getNumber() && tdResearch.getNumber().equals(number)) {
					// 开始查找上一个泛奥研究
					if (0 != i) {
						map.addAttribute("pre_research", research_list.get(i - 1));
					}

					// 开始查找下一个泛奥研究
					if (size - 1 != i) {
						map.addAttribute("next_research", research_list.get(i + 1));
					}
				}
			}
		}
		tdCommonService.setHeader(req, map);
		return "/front/research_detail";
	}
}
