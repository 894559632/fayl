package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdCompany;
import com.ynyes.fayl.repository.TdCompanyRepo;

@Service
@Transactional
public class TdCompanyService {

	@Autowired
	private TdCompanyRepo repository;

	public TdCompany save(TdCompany e) {
		if (null == e) {
			return null;
		}
		return repository.save(e);
	}

	public TdCompany findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdCompany> findAll() {
		return (List<TdCompany>) repository.findAll();
	}

	/**
	 * 获取唯一一个公司实体对象的方法
	 * 
	 * @author dengxiao
	 * 
	 */
	public TdCompany findTop() {
		PageRequest page = new PageRequest(0, 1);
		Page<TdCompany> company_page = repository.findAll(page);
		if (null == company_page) {
			return null;
		}
		List<TdCompany> content = company_page.getContent();
		if (null == content || !(content.size() > 0)) {
			return null;
		}
		return content.get(0);
	}
}
