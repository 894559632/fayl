package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdDiyLog;

public interface TdDiyLogRepo extends PagingAndSortingRepository<TdDiyLog, Long>, JpaSpecificationExecutor<TdDiyLog> {

}
