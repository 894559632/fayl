package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdSample;
import com.ynyes.fayl.repository.TdSampleRepo;

@Service
@Transactional
public class TdSampleService {

	@Autowired
	private TdSampleRepo repository;

	public TdSample save(TdSample e) {
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

	public TdSample findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdSample> findAll() {
		return (List<TdSample>) repository.findAll();
	}

	/**
	 * 查找首页推荐的案例，按照排序号正序排序（分页）
	 * 
	 * @author dengxiao
	 */
	public Page<TdSample> findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc(String categoryNumber, int page,
			int size) {
		if (null == categoryNumber) {
			return null;
		}
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc(categoryNumber, pageRequest);
	}

	/**
	 * 根据分类编号查找案例，按照排序号正序排序（分页）
	 * 
	 * @author dengxiao
	 */
	public Page<TdSample> findByCategoryNumberOrderBySortIdAsc(String categoryNumber, int page, int size) {
		if (null == categoryNumber) {
			return null;
		}
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByCategoryNumberOrderBySortIdAsc(categoryNumber, pageRequest);
	}
}
