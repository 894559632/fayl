package com.ynyes.fayl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.ynyes.fayl.entity.TdCompany;
import com.ynyes.fayl.entity.TdSampleCategory;
import com.ynyes.fayl.entity.TdSetting;
import com.ynyes.fayl.entity.TdSiteLink;

@Service
@Transactional
public class TdCommonService {

	@Autowired
	private TdSettingService tdSettingService;

	@Autowired
	private TdCompanyService tdCompanyService;

	@Autowired
	private TdSampleCategoryService tdSampleCategoryService;

	@Autowired
	private TdSiteLinkService tdSiteLinkService;

	/**
	 * 初始化公司实体对象的方法
	 * 
	 * @author dengxiao
	 */
	public void initCompany() {
		TdCompany company = tdCompanyService.findTop();
		TdCompany.setInstance(company);
	}

	/**
	 * 初始化网站设置实体类的方法
	 * 
	 * @author dengxiao
	 */
	public void initSetting() {
		TdSetting setting = tdSettingService.findTop();
		TdSetting.setInstance(setting);
	}

	/**
	 * 公共的获取网站头部数据的方法
	 * 
	 * @author DengXiao
	 */
	public void setHeader(HttpServletRequest req, ModelMap map) {
		this.initCompany();
		this.initSetting();
		// 获取所有的案例分类
		List<TdSampleCategory> sample_category_list = tdSampleCategoryService.findAll();
		map.addAttribute("sample_category_list", sample_category_list);
		// 获取网站设置
		map.addAttribute("setting", TdSetting.getInstance());
		// 获取所有的友情链接
		List<TdSiteLink> link_list = tdSiteLinkService.findAll();
		map.addAttribute("link_list", link_list);
	}
}
