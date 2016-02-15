package com.ynyes.fayl.controller.touch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.entity.TdCompany;
import com.ynyes.fayl.entity.TdCompanyInfo;
import com.ynyes.fayl.service.TdCommonService;
import com.ynyes.fayl.service.TdCompanyInfoService;

@Controller
@RequestMapping(value = "/touch/company")
public class TdTouchCompanyController {

	@Autowired
	private TdCompanyInfoService tdCompanyInfoService;

	@Autowired
	private TdCommonService tdCommonService;
	
	@RequestMapping(value = "/detail")
	public String companyDetail(HttpServletRequest req, ModelMap map) {
		TdCompany company = TdCompany.getInstance();
		// 获取公司介绍
		if (null != company) {
			String introductonNumber = company.getIntroductonNumber();
			TdCompanyInfo info = tdCompanyInfoService.findByNumber(introductonNumber);
			map.addAttribute("info", info);
			map.addAttribute("company", company);
		}
		
		tdCommonService.setHeader(req, map);
		return "/touch/company_info";
	}

}
