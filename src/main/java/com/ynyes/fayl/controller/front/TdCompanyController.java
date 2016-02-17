package com.ynyes.fayl.controller.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynyes.fayl.entity.TdCompany;
import com.ynyes.fayl.entity.TdCompanyInfo;
import com.ynyes.fayl.entity.TdJob;
import com.ynyes.fayl.service.TdCommonService;
import com.ynyes.fayl.service.TdCompanyInfoService;
import com.ynyes.fayl.service.TdDesignerService;
import com.ynyes.fayl.service.TdJobService;

/**
 * 所有关于公司的控制器
 * 
 * @author DengXiao
 */
@Controller
@RequestMapping(value = "/company")
public class TdCompanyController {

	@Autowired
	private TdCommonService tdCommonService;

	@Autowired
	private TdCompanyInfoService tdCompanyInfoService;

	@Autowired
	private TdJobService tdJobService;

	@Autowired
	private TdDesignerService tdDesignerService;

	@RequestMapping(value = "/info")
	public String companyInfo(HttpServletRequest req, ModelMap map) {
		TdCompany company = TdCompany.getInstance();
		map.addAttribute("company", company);
		if (null != company) {
			// 获取公司介绍
			String introductonNumber = company.getIntroductonNumber();
			TdCompanyInfo introduction = tdCompanyInfoService.findByNumber(introductonNumber);
			map.addAttribute("introduction", introduction);

			// 获取设计理念
			String conceptNumber = company.getConceptNumber();
			TdCompanyInfo concept = tdCompanyInfoService.findByNumber(conceptNumber);
			map.addAttribute("concept", concept);

			// 获取发展愿景
			String delvelopmentNumber = company.getDelvelopmentNumber();
			TdCompanyInfo delvelopment = tdCompanyInfoService.findByNumber(delvelopmentNumber);
			map.addAttribute("delvelopment", delvelopment);
		}
		// 获取所有的设计师
		map.addAttribute("designers", tdDesignerService.findAll());
		tdCommonService.setHeader(req, map);
		return "/front/company_info";
	}

	@RequestMapping(value = "/job")
	public String companyJobInfo(HttpServletRequest req, ModelMap map, Integer page) {
		TdCompany company = TdCompany.getInstance();
		map.addAttribute("company", company);
		if (null != company) {
			// 获取人才战略
			String jobInfoNumber = company.getJobInfoNumber();
			TdCompanyInfo jobInfo = tdCompanyInfoService.findByNumber(jobInfoNumber);
			map.addAttribute("jobInfo", jobInfo);
		}
		if (null == page) {
			page = 0;
		}
		// 查找所有的招聘信息（分页）
		Page<TdJob> job_page = tdJobService.findAll(page, 3);
		map.addAttribute("job_page", job_page);
		tdCommonService.setHeader(req, map);
		map.addAttribute("page", page);
		return "/front/company_job";
	}

	@RequestMapping(value = "/job/detail/{number}")
	public String companyJobDetail(HttpServletRequest req, ModelMap map, @PathVariable String number) {
		// 根据编号查找指定的招聘信息
		TdJob job = tdJobService.findByNumber(number);
		map.addAttribute("job", job);
		tdCommonService.setHeader(req, map);
		return "/front/job_detail";
	}

	@RequestMapping(value = "/contact")
	public String companyContact(HttpServletRequest req, ModelMap map) {
		tdCommonService.setHeader(req, map);
		return "/front/company_contact";
	}
}
