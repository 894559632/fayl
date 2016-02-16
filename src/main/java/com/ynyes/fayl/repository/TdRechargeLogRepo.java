package com.ynyes.fayl.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdRechargeLog;

public interface TdRechargeLogRepo
		extends PagingAndSortingRepository<TdRechargeLog, Long>, JpaSpecificationExecutor<TdRechargeLog> {

	TdRechargeLog findByNum(String num);

	Page<TdRechargeLog> findByMoneyGreaterThanOrderByRechargeDateDesc(Double money, Pageable page);

	Page<TdRechargeLog> findByUsernameContainingAndMoneyGreaterThanOrderByRechargeDateDesc(String keywords,
			Double money, Pageable page);
	
	/*zhangji*/
	Page<TdRechargeLog> findByRechargeDateAfterOrderByRechargeDateDesc(Date date, Pageable page);
	Page<TdRechargeLog> findByRechargeDateBeforeOrderByRechargeDateDesc(Date date, Pageable page);
	Page<TdRechargeLog> findByRechargeDateAfterAndRechargeDateBeforeOrderByRechargeDateDesc(Date date1, Date date2,Pageable page);
	
	Page<TdRechargeLog> findByNumContainingOrUsernameContainingOrderByRechargeDateDesc
		(String keywords1, String keywords2 , Pageable page);
	Page<TdRechargeLog> findByRechargeDateAfterAndNumContainingOrRechargeDateAfterAndUsernameContainingOrderByRechargeDateDesc
		(Date date1,String keywords1, Date date2 , String keywords2 , Pageable page);
	Page<TdRechargeLog> findByRechargeDateBeforeAndNumContainingOrRechargeDateBeforeAndUsernameContainingOrderByRechargeDateDesc
		(Date date1, String keywords1, Date date2 , Pageable page);
	Page<TdRechargeLog> findByRechargeDateAfterAndRechargeDateBeforeAndNumContainingOrRechargeDateAfterAndRechargeDateBeforeAndUsernameContainingOrderByRechargeDateDesc
		(Date date1, Date date2, String keywords1 ,Date date3 ,Date date4 ,String keywords2 ,Pageable page);
}
