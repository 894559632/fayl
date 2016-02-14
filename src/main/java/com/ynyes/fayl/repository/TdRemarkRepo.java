package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdRemark;

public interface TdRemarkRepo extends PagingAndSortingRepository<TdRemark, Long>, JpaSpecificationExecutor<TdRemark> {

	/**
	 * 根据编号查找用户留言
	 * 
	 * @author DengXiao
	 */
	TdRemark findByNumber(String number);
}
