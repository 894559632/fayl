package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdSetting;

public interface TdSettingRepo extends PagingAndSortingRepository<TdSetting, Long>,JpaSpecificationExecutor<TdSetting>{

}
