package com.ynyes.fayl.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdAd;
import com.ynyes.fayl.repository.TdAdRepo;

@Service
@Transactional
public class TdAdService {

	@Autowired
	private TdAdRepo repository;

	public TdAd save(TdAd e) {
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

	public TdAd findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdAd> findAll() {
		return (List<TdAd>) repository.findAll();
	}
	
	public Page<TdAd> findAll(int page,int size){
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findAll(pageRequest);
	}

	/**
	 * 根据分类编号查找所有的启用的未过期的广告，并按照排序号正序排序（不分页）
	 * 
	 * @author dengxiao
	 */
	public List<TdAd> findByCategoryNumberAndIsEnableTrueAndStartTimeBeforeAndEndTimeAfterOrderBySortIdAsc(
			String categoryNumber) {
		if (null == categoryNumber) {
			return null;
		}
		return repository.findByCategoryNumberAndIsEnableTrueAndStartTimeBeforeAndEndTimeAfterOrderBySortIdAsc(
				categoryNumber, new Date(), new Date());
	}

	/**
	 * 根据分类编号查找所有的启用的未过期的广告，并按照排序号正序排序（分页）
	 * 
	 * @author dengxiao
	 */
	public Page<TdAd> findByCategoryNumberAndIsEnableTrueAndStartTimeBeforeAndEndTimeAfterOrderBySortIdAsc(
			String categoryNumber, int page, int size) {
		if (null == categoryNumber) {
			return null;
		}
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByCategoryNumberAndIsEnableTrueAndStartTimeBeforeAndEndTimeAfterOrderBySortIdAsc(
				categoryNumber, new Date(), new Date(), pageRequest);
	}

}
