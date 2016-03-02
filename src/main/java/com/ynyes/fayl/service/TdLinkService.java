package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
}
