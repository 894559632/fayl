package com.ynyes.fayl.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdCompany;
import com.ynyes.fayl.entity.TdSetting;

@Service
@Transactional
public class TdCommonService {

	@Autowired
	private TdSettingService tdSettingService;

	@Autowired
	private TdCompanyService tdCompanyService;

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
}
