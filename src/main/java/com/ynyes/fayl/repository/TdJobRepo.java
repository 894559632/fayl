package com.ynyes.fayl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdJob;

public interface TdJobRepo extends PagingAndSortingRepository<TdJob, Long>, JpaSpecificationExecutor<TdJob> {

	/**
	 * 根据招聘信息编号查找制定的招聘信息
	 * 
	 * @author DengXiao
	 */
	TdJob findByNumber(String number);

	/**
	 * 模糊查询职务标题
	 * 
	 * @author DengXiao
	 */
	Page<TdJob> findByTitleContainingOrderBySortIdAsc(String keywords, Pageable page);
}
