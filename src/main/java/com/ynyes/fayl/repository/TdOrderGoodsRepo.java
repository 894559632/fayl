package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdOrderGoods;

/**
 * TdOrderGoods 实体数据库操作接口
 * 
 * @author Sharon
 *
 */

public interface TdOrderGoodsRepo extends
		PagingAndSortingRepository<TdOrderGoods, Long>,
		JpaSpecificationExecutor<TdOrderGoods> 
{
}
