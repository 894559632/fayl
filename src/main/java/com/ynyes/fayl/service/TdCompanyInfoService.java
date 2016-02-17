package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

	public Page<TdCompanyInfo> findAll(int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size, new Sort(Direction.ASC, "sortId"));
		return repository.findAll(pageRequest);
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

	/**
	 * 信息标题模糊查询（分页）
	 * 
	 * @author DengXiao
	 */
	public Page<TdCompanyInfo> findByTitleContainingOrderBySortIdAsc(String keywords, int page, int size) {
		if (null == keywords) {
			return null;
		}
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByTitleContainingOrderBySortIdAsc(keywords, pageRequest);
	}
}
