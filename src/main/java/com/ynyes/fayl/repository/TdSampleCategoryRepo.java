package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdSampleCategory;

public interface TdSampleCategoryRepo
		extends PagingAndSortingRepository<TdSampleCategory, Long>, JpaSpecificationExecutor<TdSampleCategory> {
	/**
	 * 根据查询编号查找到指定的案例分类
	 * 
	 * @author DengXiao
	 */
	TdSampleCategory findByNumber(String number);
}
