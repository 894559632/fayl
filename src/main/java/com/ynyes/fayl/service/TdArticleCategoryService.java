package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdArticleCategory;
import com.ynyes.fayl.repository.TdArticleCategoryRepo;

@Service
@Transactional
public class TdArticleCategoryService {

	@Autowired
	private TdArticleCategoryRepo repository;

	public TdArticleCategory save(TdArticleCategory e) {
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

	public TdArticleCategory findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdArticleCategory> findAll() {
		return (List<TdArticleCategory>) repository.findAll();
	}

	/**
	 * 根据分类编号查找分类
	 * 
	 * @author dengxiao
	 */
	public TdArticleCategory findByNumber(String number) {
		if (null == number) {
			return null;
		}
		return repository.findByNumber(number);
	}

	/**
	 * 根据分类名称查找分类
	 * 
	 * @author dengxiao
	 */
	public TdArticleCategory findByTitle(String title) {
		if (null == title) {
			return null;
		}
		return repository.findByTitle(title);
	}
}
