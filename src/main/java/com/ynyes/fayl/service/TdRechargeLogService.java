package com.ynyes.fayl.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdRechargeLog;
import com.ynyes.fayl.repository.TdRechargeLogRepo;

@Service
@Transactional
public class TdRechargeLogService {

	@Autowired
	TdRechargeLogRepo repository;

	public TdRechargeLog save(TdRechargeLog e) {
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

	public TdRechargeLog findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdRechargeLog> findAll() {
		return (List<TdRechargeLog>) repository.findAll();
	}

	public TdRechargeLog findByNum(String num) {
		if (null == num) {
			return null;
		}
		return repository.findByNum(num);
	}

	public Page<TdRechargeLog> findByIdNotNullOrderByRechargeDateDesc(int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByMoneyGreaterThanOrderByRechargeDateDesc(0.0, pageRequest);
	}

	public Page<TdRechargeLog> findByUsernameContainingOrderByRechargeDateDesc(String keywords, int page, int size) {
		if (null == keywords) {
			return null;
		}
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByUsernameContainingAndMoneyGreaterThanOrderByRechargeDateDesc(keywords, 0.0,
				pageRequest);
	}
	
	
	/*zhangji*/
	/*
	 * 无keywords，date2，
	 * 1 
	 * 查找date1以后的
	 */
	public Page<TdRechargeLog> findByRechargeDateAfterOrderByRechargeDateDesc(Date date1 ,int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByRechargeDateAfterOrderByRechargeDateDesc(date1, pageRequest);
	}
	
	/**
	 * 无keywords，date1
	 * 2
	 * 查找date2以前的
	 */
	public Page<TdRechargeLog> findByRechargeDateBeforeOrderByRechargeDateDesc(Date date2 ,int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByRechargeDateBeforeOrderByRechargeDateDesc(date2, pageRequest);
	}
	
	/**
	 * 无keywords
	 * 12
	 * 查找date1与date2之间的
	 */
	public Page<TdRechargeLog> findByRechargeDateAfterAndRechargeDateBeforeOrderByRechargeDateDesc(Date date1 ,Date date2 ,int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByRechargeDateAfterAndRechargeDateBeforeOrderByRechargeDateDesc(date1, date2 , pageRequest);
	}
	
	/**
	 * 无date1，date2
	 * 0
	 * 关键字查找
	 */
	public Page<TdRechargeLog> findBySearchOrderByRechargeDateDesc(String keywords , int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByNumContainingOrUsernameContainingOrderByRechargeDateDesc(keywords ,keywords ,pageRequest);
	}
	
	/**
	 * 无date2
	 * 01
	 * 关键字，查找date1以后的
	 */
	public Page<TdRechargeLog> findByRechargeDateAfterAndSearchOrderByRechargeDateDesc(Date date1 ,String keywords , int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByRechargeDateAfterAndNumContainingOrRechargeDateAfterAndUsernameContainingOrderByRechargeDateDesc
				(date1 ,keywords ,new Date() ,keywords ,pageRequest);
	}
	
	/**
	 * 无date1
	 * 02
	 * 关键字，查找date2以前的
	 */
	public Page<TdRechargeLog> findByRechargeDateBeforeAndSearchOrderByRechargeDateDesc(Date date2 ,String keywords , int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByRechargeDateAfterAndNumContainingOrRechargeDateAfterAndUsernameContainingOrderByRechargeDateDesc
				(date2 ,keywords ,date2 ,keywords ,pageRequest);
	}
	
	/**
	 * 012
	 * 关键字，查找date1和date2之间的
	 */
	public Page<TdRechargeLog> findByRechargeDateAfterAndRechargeDateBeforeAndSearchOrderByRechargeDateDesc(Date date1 , Date date2 ,String keywords , int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByRechargeDateAfterAndRechargeDateBeforeAndNumContainingOrRechargeDateAfterAndRechargeDateBeforeAndUsernameContainingOrderByRechargeDateDesc
				(date1 , date2 , keywords , date1 ,date2 ,keywords ,pageRequest);
	}
}
