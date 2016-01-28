package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdCompanyInfo;

public interface TdCompanyInfoRepo
		extends PagingAndSortingRepository<TdCompanyInfo, Long>, JpaSpecificationExecutor<TdCompanyInfo> {

	/**
	 * 根据指定的编号查找公司信息实体
	 * 
	 * @author dengxiao
	 */
	TdCompanyInfo findByNumber(String number);
}
