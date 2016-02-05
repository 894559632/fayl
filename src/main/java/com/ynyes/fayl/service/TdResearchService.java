package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdResearch;
import com.ynyes.fayl.repository.TdResearchRepo;

@Service
@Transactional
public class TdResearchService {

	@Autowired
	private TdResearchRepo repository;

	public TdResearch save(TdResearch e) {
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

	public TdResearch findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdResearch> findAll() {
		return (List<TdResearch>) repository.findAll();
	}

	public Page<TdResearch> findAll(int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size, new Sort(Direction.ASC, "sortId"));
		return repository.findAll(pageRequest);
	}

	/**
	 * 根据编号查找指定的泛奥研究
	 * 
	 * @author DengXiao
	 */
	public TdResearch findByNumber(String number) {
		if (null == number) {
			return null;
		}
		return repository.findByNumber(number);
	}
}
