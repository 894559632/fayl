package com.ynyes.fayl.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdDeposit;

public interface TdDepositRepo extends PagingAndSortingRepository<TdDeposit, Long>, JpaSpecificationExecutor<TdDeposit>{

	/**
	 * @author dengxiao
	 * 根据停车场ID查找到所有的提现记录
	 */
	List<TdDeposit> findByDiyIdAndIsRemitTrueOrderByDepositDateDesc(Long diyId);
	
	
	List<TdDeposit> findByDiyIdOrderByDepositDateDesc(Long diyId);
	/**
	 * @author dengxiao
	 * 根据用户id查找提现记录
	 */
	List<TdDeposit> findByUserIdOrderByDepositDateDesc(Long userId);
	
	/*-------------------------zhangji--------------------------*/
	/**
	 * @author Zhangji
	 * 用户提现
	 */
	Page<TdDeposit> findByDiyIdNullAndUsernameNotNull(Pageable page);
	Page<TdDeposit> findByDiyIdNullAndUsernameNotNullAndDepositDateBefore( Date date ,Pageable page);
	Page<TdDeposit> findByDiyIdNullAndUsernameNotNullAndDepositDateAfter( Date date ,Pageable page);
	Page<TdDeposit> findByDiyIdNullAndUsernameNotNullAndDepositDateAfterAndDepositDateBefore( Date date1 , Date date2 ,Pageable page);
	
	/*用户提现搜索*/
	Page<TdDeposit> findByDiyIdNullAndUsernameNotNullAndUsernameContainingOrDiyIdNullAndUsernameNotNullAndNumContaining(String keywords1 , String keywords2 , Pageable page); 
	Page<TdDeposit> findByDiyIdNullAndUsernameNotNullAndDepositDateBeforeAndUsernameContainingOrDiyIdNullAndUsernameNotNullAndDepositDateBeforeAndNumContaining(Date date1 ,String keywords1 ,Date date2 , String keywords2 , Pageable page); 
	Page<TdDeposit> findByDiyIdNullAndUsernameNotNullAndDepositDateAfterAndUsernameContainingOrDiyIdNullAndUsernameNotNullAndDepositDateAfterAndNumContaining(Date date1 ,String keywords1 ,Date date2 , String keywords2 , Pageable page);
	Page<TdDeposit> findByDiyIdNullAndUsernameNotNullAndDepositDateAfterAndDepositDateBeforeAndUsernameContainingOrDiyIdNullAndUsernameNotNullAndDepositDateAfterAndDepositDateBeforeAndNumContaining(Date date1, Date date2 ,String keywords1 ,Date date3 ,Date date4 , String keywords2 , Pageable page);
	/**
	 * @author Zhangji
	 * 车库提现
	 */
	Page<TdDeposit> findByDiyIdNotNullAndUsernameNull(Pageable page);
	Page<TdDeposit> findByDiyIdNotNullAndUsernameNullAndDepositDateBefore( Date date ,Pageable page);
	Page<TdDeposit> findByDiyIdNotNullAndUsernameNullAndDepositDateAfter( Date date ,Pageable page);
	Page<TdDeposit> findByDiyIdNotNullAndUsernameNullAndDepositDateAfterAndDepositDateBefore( Date date1 , Date date2 ,Pageable page);
	/*用户提现搜索*/
	Page<TdDeposit> findByDiyIdNotNullAndUsernameNullAndDiyNameContainingOrDiyIdNotNullAndUsernameNullAndNumContaining(String keywords1 , String keywords2 , Pageable page);
	Page<TdDeposit> findByDiyIdNotNullAndUsernameNullAndDepositDateBeforeAndDiyNameContainingOrDiyIdNotNullAndUsernameNullAndDepositDateBeforeAndNumContaining(Date date1 ,String keywords1 ,Date date2 , String keywords2 , Pageable page); 
	Page<TdDeposit> findByDiyIdNotNullAndUsernameNullAndDepositDateAfterAndDiyNameContainingOrDiyIdNotNullAndUsernameNullAndDepositDateAfterAndNumContaining(Date date1 ,String keywords1 ,Date date2 , String keywords2 , Pageable page);
	Page<TdDeposit> findByDiyIdNotNullAndUsernameNullAndDepositDateAfterAndDepositDateBeforeAndDiyNameContainingOrDiyIdNotNullAndUsernameNullAndDepositDateAfterAndDepositDateBeforeAndNumContaining(Date date1, Date date2 ,String keywords1 ,Date date3 ,Date date4 , String keywords2 , Pageable page);
}
