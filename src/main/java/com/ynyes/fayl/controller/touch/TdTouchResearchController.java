package com.ynyes.fayl.controller.touch;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.entity.TdResearch;
import com.ynyes.fayl.service.TdResearchService;

@Controller
@RequestMapping(value = "/touch/research")
public class TdTouchResearchController {

	@Autowired
	private TdResearchService tdResearchService;

	@RequestMapping(value = "/list")
	public String researchList(HttpServletRequest req, ModelMap map) {
		List<TdResearch> research_list = tdResearchService.findAll();
		map.addAttribute("research_list", research_list);
		return "/touch/research_list";
	}

	@RequestMapping(value = "/detail")
	public String researchDetail(HttpServletRequest req, ModelMap map, String number) {
		TdResearch research = tdResearchService.findByNumber(number);
		map.addAttribute("research", research);
		return "/touch/research_detail";
	}
}
