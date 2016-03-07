package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdLink;
import com.ynyes.fayl.repository.TdLinkRepo;

@Service
@Transactional
public class TdLinkService {

	@Autowired
	private TdLinkRepo repository;

	public TdLink save(TdLink e) {
		if (null == e) {
			return e;
		}
		return repository.save(e);
	}

	public void delete(Long id) {
		if (null != id) {
			repository.delete(id);
		}
	}

	public TdLink findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdLink> findAll() {
		return (List<TdLink>) repository.findAll();
	}

	public List<TdLink> findAllOrderBySortIdAsc() {
		Sort sort = new Sort(Direction.ASC, "sortId");
		return (List<TdLink>) repository.findAll(sort);
	}

	/**
	 * 根据指定的友情链接编号查找
	 * 
	 * @author DengXiao
	 */
	public TdLink findByNumber(String number) {
		if (null == number) {
			return null;
		}
		return repository.findByNumber(number);
	}

	/**
	 * 根据标题查找友情链接
	 * 
	 * @author DengXiao
	 */
	public TdLink findByTitle(String title) {
		if (null == title) {
			return null;
		}
		return repository.findByTitle(title);
	}

	public TdLink findByTitleAndIdNot(String title, Long id) {
		if (null == title || null == id) {
			return null;
		}
		return repository.findByTitleAndIdNot(title, id);
	}

	public Page<TdLink> findAllOrderBySortIdAsc(int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size, new Sort(Direction.ASC, "sortId"));
		return repository.findAll(pageRequest);
	}
}
