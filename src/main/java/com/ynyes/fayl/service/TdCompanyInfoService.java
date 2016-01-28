package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdCompanyInfo;
import com.ynyes.fayl.repository.TdCompanyInfoRepo;

@Service
@Transactional
public class TdCompanyInfoService {

	@Autowired
	private TdCompanyInfoRepo repository;

	public TdCompanyInfo save(TdCompanyInfo e) {
		if (null == e) {
			return null;
		}
		return repository.save(e);
	}

	public void delete(Long id) {
		if (null != id) {
			repository.delete(id);
		}
	}

	public TdCompanyInfo findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdCompanyInfo> findAll() {
		return (List<TdCompanyInfo>) repository.findAll();
	}

	/**
	 * 根据指定的编号查找公司信息实体
	 * 
	 * @author dengxiao
	 */
	public TdCompanyInfo findByNumber(String number) {
		if (null == number) {
			return null;
		}
		return repository.findByNumber(number);
	}
}
