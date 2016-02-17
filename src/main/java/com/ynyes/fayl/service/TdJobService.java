package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdJob;
import com.ynyes.fayl.repository.TdJobRepo;

@Service
@Transactional
public class TdJobService {

	@Autowired
	private TdJobRepo repository;

	public TdJob save(TdJob e) {
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

	public TdJob findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdJob> findAll() {
		return (List<TdJob>) repository.findAll();
	}

	public Page<TdJob> findAll(int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size, new Sort(Direction.ASC, "sortId"));
		return repository.findAll(pageRequest);
	}

	/**
	 * 根据招聘信息的编号查找指定的招聘信息
	 * 
	 * @author DengXiao
	 */
	public TdJob findByNumber(String number) {
		if (null == number) {
			return null;
		}
		return repository.findByNumber(number);
	}

	/**
	 * 模糊查询职务标题
	 * 
	 * @author DengXiao
	 */
	public Page<TdJob> findByTitleContainingOrderBySortIdAsc(String keywords, int page, int size) {
		if (null == keywords) {
			return null;
		}
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByTitleContainingOrderBySortIdAsc(keywords, pageRequest);
	}
}
