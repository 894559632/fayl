package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdShippingAddress;

/**
 * TdShippingAddress 实体数据库操作接口
 * 
 * @author Sharon
 *
 */

public interface TdShippingAddressRepo extends
		PagingAndSortingRepository<TdShippingAddress, Long>,
		JpaSpecificationExecutor<TdShippingAddress> 
{
}
