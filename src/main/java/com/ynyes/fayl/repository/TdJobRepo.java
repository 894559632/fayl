package com.ynyes.fayl.repository;

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
}
