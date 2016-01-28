package com.ynyes.fayl.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdAd;

public interface TdAdRepo extends PagingAndSortingRepository<TdAd, Long>, JpaSpecificationExecutor<TdAd> {

	/**
	 * 根据分类编号查找所有的启用的未过期的广告，并按照排序号正序排序（不分页）
	 * 
	 * @author dengxiao
	 */
	List<TdAd> findByCategoryNumberAndIsEnableTrueAndStartTimeBeforeAndEndTimeAfterOrderBySortIdAsc(
			String categoryNumber, Date startTime, Date endTime);

	/**
	 * 根据分类编号查找所有的启用的未过期的广告，并按照排序号正序排序（分页）
	 * 
	 * @author dengxiao
	 */
	Page<TdAd> findByCategoryNumberAndIsEnableTrueAndStartTimeBeforeAndEndTimeAfterOrderBySortIdAsc(
			String categoryNumber, Date startTime, Date endTime, Pageable page);

}
