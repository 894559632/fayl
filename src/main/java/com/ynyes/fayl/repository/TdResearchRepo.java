package com.ynyes.fayl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdResearch;

public interface TdResearchRepo
		extends PagingAndSortingRepository<TdResearch, Long>, JpaSpecificationExecutor<TdResearch> {

	/**
	 * 根据编号查找指定的泛奥研究
	 * 
	 * @author DengXiao
	 */
	TdResearch findByNumber(String number);

	/**
	 * 研究标题模糊查询
	 * 
	 * @author DengXiao
	 */
	Page<TdResearch> findByTitleContainingOrderBySortIdAsc(String keywords, Pageable page);
}
