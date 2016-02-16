package com.ynyes.fayl.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ynyes.fayl.entity.TdDeposit;
import com.ynyes.fayl.repository.TdDepositRepo;

@Service
@Transactional
public class TdDepositService {

	@Autowired
	private TdDepositRepo repository;

	public TdDeposit save(TdDeposit e) {
		if (null == e) {
			return null;
		}
		return repository.save(e);
	}

	public void delete(Long id) {
		if (null != id) {
			repository.delete(id);
		}
	}

	public TdDeposit findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdDeposit> findAll() {
		return (List<TdDeposit>) repository.findAll();
	}

	/**
	 * @author dengxiao 根据停车场的ID查找所有的提现记录
	 */
	public List<TdDeposit> findByDiyIdAndIsRemitTrueOrderByDepositDateDesc(Long diyId) {
		if (null == diyId) {
			return null;
		}
		return repository.findByDiyIdAndIsRemitTrueOrderByDepositDateDesc(diyId);
	}
	
	public List<TdDeposit> findByDiyIdOrderByDepositDateDesc(Long diyId) {
		if (null == diyId) {
			return null;
		}
		return repository.findByDiyIdOrderByDepositDateDesc(diyId);
	}

	/**
	 * @author dengxiao 根据用户的ID查找所有的提现记录
	 */
	public List<TdDeposit> findByUserIdOrderByDepositDateDesc(Long userId) {
		if (null == userId) {
			return null;
		}
		return repository.findByUserIdOrderByDepositDateDesc(userId);
	}
	
	/*---------------zhangji------------------*/
	
	/*--------------用户提现----------------*/
	public Page<TdDeposit> findByDiyIdNullAndUsernameNotNull(int page , int size){
		PageRequest pageRequest = new PageRequest(page ,size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNullAndUsernameNotNull(pageRequest);
	}
	public Page<TdDeposit> findByDepositDateBefore(Date date ,int page , int size){
		PageRequest pageRequest = new PageRequest(page ,size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNullAndUsernameNotNullAndDepositDateBefore(date ,pageRequest);
	}
	public Page<TdDeposit> findByDepositDateAfter(Date date ,int page , int size){
		PageRequest pageRequest = new PageRequest(page ,size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNullAndUsernameNotNullAndDepositDateAfter( date ,pageRequest);
	}
	public Page<TdDeposit> findByDepositDateAfterAndDepositDateBefore(Date date1 , Date date2 ,int page , int size){
		PageRequest pageRequest = new PageRequest(page ,size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNullAndUsernameNotNullAndDepositDateAfterAndDepositDateBefore( date1 , date2 ,pageRequest);
	}
	
//搜索		
	public Page<TdDeposit> findAll(int page , int size){
		PageRequest pageRequest = new PageRequest(page ,size , new Sort(Direction.DESC,"depositDate"));
		return repository.findAll(pageRequest);
	}
	
	public Page<TdDeposit> findBySearchUser(String keywords , int page , int size){
		PageRequest pageRequest = new PageRequest(page , size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNullAndUsernameNotNullAndUsernameContainingOrDiyIdNullAndUsernameNotNullAndNumContaining(keywords , keywords , pageRequest);
	}
	public Page<TdDeposit> findBySearchUserAndDepositDateBefore(Date date ,String keywords , int page , int size){
		PageRequest pageRequest = new PageRequest(page , size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNullAndUsernameNotNullAndDepositDateBeforeAndUsernameContainingOrDiyIdNullAndUsernameNotNullAndDepositDateBeforeAndNumContaining(date ,keywords , date , keywords , pageRequest);
	}
	public Page<TdDeposit> findBySearchUserAndDepositDateAfter(Date date ,String keywords , int page , int size){
		PageRequest pageRequest = new PageRequest(page , size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNullAndUsernameNotNullAndDepositDateAfterAndUsernameContainingOrDiyIdNullAndUsernameNotNullAndDepositDateAfterAndNumContaining(date ,keywords , date , keywords , pageRequest);
	}
	public Page<TdDeposit> findBySearchUserAndDepositDateAfterAndDepositDateBefore(Date date1 , Date date2 ,String keywords , int page , int size){
		PageRequest pageRequest = new PageRequest(page , size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNullAndUsernameNotNullAndDepositDateAfterAndDepositDateBeforeAndUsernameContainingOrDiyIdNullAndUsernameNotNullAndDepositDateAfterAndDepositDateBeforeAndNumContaining(date1 , date2 , keywords , date1 , date2 , keywords , pageRequest);
	}
	/*------------------用户提现 end -------------------*/
	
	/*------------------车库提现 ------------------------*/
	
	
	
	public Page<TdDeposit> findByDiyIdNotNullAndUsernameNull(int page , int size){
		PageRequest pageRequest = new PageRequest(page ,size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNotNullAndUsernameNull(pageRequest);
	}
	
	public Page<TdDeposit> findBySearchDiy(String keywords , int page , int size){
		PageRequest pageRequest = new PageRequest(page , size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNotNullAndUsernameNullAndDiyNameContainingOrDiyIdNotNullAndUsernameNullAndNumContaining(keywords , keywords , pageRequest);
	}
	
	

	public Page<TdDeposit> findByDepositDateBefore2(Date date ,int page , int size){
		PageRequest pageRequest = new PageRequest(page ,size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNotNullAndUsernameNullAndDepositDateBefore(date ,pageRequest);
	}
	public Page<TdDeposit> findByDepositDateAfter2(Date date ,int page , int size){
		PageRequest pageRequest = new PageRequest(page ,size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNotNullAndUsernameNullAndDepositDateAfter( date ,pageRequest);
	}
	public Page<TdDeposit> findByDepositDateAfterAndDepositDateBefore2(Date date1 , Date date2 ,int page , int size){
		PageRequest pageRequest = new PageRequest(page ,size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNotNullAndUsernameNullAndDepositDateAfterAndDepositDateBefore( date1 , date2 ,pageRequest);
	}
	
//搜索		
	
	public Page<TdDeposit> findBySearchUser2(String keywords , int page , int size){
		PageRequest pageRequest = new PageRequest(page , size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNotNullAndUsernameNullAndDiyNameContainingOrDiyIdNotNullAndUsernameNullAndNumContaining(keywords , keywords , pageRequest);
	}
	public Page<TdDeposit> findBySearchUserAndDepositDateBefore2(Date date ,String keywords , int page , int size){
		PageRequest pageRequest = new PageRequest(page , size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNotNullAndUsernameNullAndDepositDateBeforeAndDiyNameContainingOrDiyIdNotNullAndUsernameNullAndDepositDateBeforeAndNumContaining(date ,keywords , date , keywords , pageRequest);
	}
	public Page<TdDeposit> findBySearchUserAndDepositDateAfter2(Date date ,String keywords , int page , int size){
		PageRequest pageRequest = new PageRequest(page , size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNotNullAndUsernameNullAndDepositDateAfterAndDiyNameContainingOrDiyIdNotNullAndUsernameNullAndDepositDateAfterAndNumContaining(date ,keywords , date , keywords , pageRequest);
	}
	public Page<TdDeposit> findBySearchUserAndDepositDateAfterAndDepositDateBefore2(Date date1 , Date date2 ,String keywords , int page , int size){
		PageRequest pageRequest = new PageRequest(page , size , new Sort(Direction.DESC,"depositDate"));
		return repository.findByDiyIdNotNullAndUsernameNullAndDepositDateAfterAndDepositDateBeforeAndDiyNameContainingOrDiyIdNotNullAndUsernameNullAndDepositDateAfterAndDepositDateBeforeAndNumContaining(date1 , date2 , keywords , date1 , date2 , keywords , pageRequest);
	}
	/******************车库提现 end ----------------------*/
}
