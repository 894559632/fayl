package com.ynyes.fayl.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdIOData;

/**
 * TdIOData 实体数据库操作接口
 * 
 * @author Sharon
 *
 */

public interface TdIODataRepo extends
		PagingAndSortingRepository<TdIOData, Long>,
		JpaSpecificationExecutor<TdIOData> 
{
    TdIOData findTopByBusNoAndIoDate(String busNo, Date ioTime);
}
