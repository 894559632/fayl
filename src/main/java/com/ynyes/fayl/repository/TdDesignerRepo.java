package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdDesigner;

public interface TdDesignerRepo
		extends PagingAndSortingRepository<TdDesigner, Long>, JpaSpecificationExecutor<TdDesigner> {

	TdDesigner findByNumber(String number);
}
