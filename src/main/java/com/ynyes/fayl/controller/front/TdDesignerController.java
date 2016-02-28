package com.ynyes.fayl.controller.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.entity.TdDesigner;
import com.ynyes.fayl.service.TdCommonService;
import com.ynyes.fayl.service.TdDesignerService;

@Controller
@RequestMapping(value = "/designer")
public class TdDesignerController {

	@Autowired
	private TdDesignerService tdDesignerService;

	@Autowired
	private TdCommonService tdCommonService;

	@RequestMapping(value = "/detail")
	public String designerDetail(HttpServletRequest req, ModelMap map, String number) {
		TdDesigner designer = tdDesignerService.findByNumber(number);
		map.addAttribute("designer", designer);
		tdCommonService.setHeader(req, map);
		return "/front/designer_detail";
	}
}
