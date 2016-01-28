package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdSetting;
import com.ynyes.fayl.repository.TdSettingRepo;

@Service
@Transactional
public class TdSettingService {

	@Autowired
	private TdSettingRepo repository;

	public TdSetting save(TdSetting e) {
		if (null == e) {
			return null;
		}
		return repository.save(e);
	}

	public TdSetting findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}
	
	public List<TdSetting> findAll(){
		return (List<TdSetting>) repository.findAll();
	}
	
	/**
	 * 查找到唯一一个网站设置实体对象的方法
	 * 
	 * @author dengxiao
	 */
	public TdSetting findTop(){
		PageRequest page = new PageRequest(0, 1);
		Page<TdSetting> setting_page = repository.findAll(page);
		if(null == setting_page){
			return null;
		}
		List<TdSetting> content = setting_page.getContent();
		if(null == content || !(content.size() > 0)){
			return null;
		}
		return content.get(0);
	}
}
