package com.ynyes.fayl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdSample;

public interface TdSampleRepo extends PagingAndSortingRepository<TdSample, Long>, JpaSpecificationExecutor<TdSample> {

	/**
	 * 查找指定分类下首页推荐的案例，按照排序号正序排序（分页）
	 * 
	 * @author dengxiao
	 */
	Page<TdSample> findByCategoryNumberAndIsIndexRecommendTrueOrderBySortIdAsc(String categoryNumber, Pageable page);

	/**
	 * 根据分类编号查找案例，按照排序号正序排序（分页）
	 * 
	 * @author dengxiao
	 */
	Page<TdSample> findByCategoryNumberOrderBySortIdAsc(String categoryNumber, Pageable page);
}
