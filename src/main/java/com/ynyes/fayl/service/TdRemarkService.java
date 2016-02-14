package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdRemark;
import com.ynyes.fayl.repository.TdRemarkRepo;

@Service
@Transactional
public class TdRemarkService {

	@Autowired
	private TdRemarkRepo repository;

	public TdRemark save(TdRemark e) {
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

	public TdRemark findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdRemark> findAll() {
		return (List<TdRemark>) repository.findAll();
	}

	public Page<TdRemark> findAll(int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size, new Sort(Direction.ASC, "sortId"));
		return repository.findAll(pageRequest);
	}

	/**
	 * 根据编号查找用户留言
	 * 
	 * @author DengXiao
	 */
	public TdRemark findByNumber(String number) {
		if (null == number) {
			return null;
		}
		return repository.findByNumber(number);
	}
}
