package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdAdType;

public interface TdAdTypeRepo extends PagingAndSortingRepository<TdAdType, Long>, JpaSpecificationExecutor<TdAdType> {

	/**
	 * 根据分类名称查找广告位
	 * 
	 * @author dengxiao
	 */
	TdAdType findByTitle(String title);
}
