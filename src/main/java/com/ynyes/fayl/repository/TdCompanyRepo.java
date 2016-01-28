package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdCompany;

public interface TdCompanyRepo extends PagingAndSortingRepository<TdCompany, Long> ,JpaSpecificationExecutor<TdCompany>{

}
