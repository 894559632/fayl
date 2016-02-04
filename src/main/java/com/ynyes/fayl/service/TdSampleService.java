package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	
	/**
	 * 根据分类编号查找案例，按照排序号正序排序（不分页）
	 * 
	 * @author dengxiao
	 */
	public List<TdSample> findByCategoryNumberOrderBySortIdAsc(String categoryNumber){
		if(null == categoryNumber){
			return null;
		}
		return repository.findByCategoryNumberOrderBySortIdAsc(categoryNumber);
	}

	/**
	 * 根据编号查找指定的案例
	 * 
	 * @author DengXiao
	 */
	public TdSample findByNumber(String number){
		if(null == number){
			return null;
		}
		return repository.findByNumber(number);
	}
}
