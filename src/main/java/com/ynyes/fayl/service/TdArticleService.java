package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdArticle;
import com.ynyes.fayl.repository.TdArticleRepo;

@Service
@Transactional
public class TdArticleService {

	@Autowired
	private TdArticleRepo repository;

	public TdArticle save(TdArticle e) {
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

	public TdArticle findOne(Long id) {
		if (null == id) {
			return null;
		}
		return repository.findOne(id);
	}

	public List<TdArticle> findAll() {
		return (List<TdArticle>) repository.findAll();
	}

	/**
	 * 根据分类编号查找文章，按照排序号正序排序（不分页）
	 * 
	 * @author dengxiao
	 */
	public List<TdArticle> findByNumberOrderBySortIdAsc(String number) {
		if (null == number) {
			return null;
		}
		return repository.findByNumberOrderBySortIdAsc(number);
	}

	/**
	 * 根据分类编号查找文章，按照排序号正序排序（分页）
	 * 
	 * @author dengxiao
	 */
	public Page<TdArticle> findByNumberOrderBySortIdAsc(String number, int page, int size) {
		if (null == number) {
			return null;
		}
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByNumberOrderBySortIdAsc(number, pageRequest);
	}

	/**
	 * 根据分类编号查找文章，按照生成时间反序排序（不分页）
	 * 
	 * @author dengxiao
	 */
	public List<TdArticle> findByNumberOrderByCreateDateDesc(String number) {
		if (null == number) {
			return null;
		}
		return repository.findByNumberOrderByCreateDateDesc(number);
	}

	/**
	 * 根据分类编号查找文章，按照生成时间反序排序（分页）
	 * 
	 * @author dengxiao
	 */
	public Page<TdArticle> findByNumberOrderByCreateDateDesc(String number, int page, int size) {
		if (null == number) {
			return null;
		}
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByNumberOrderByCreateDateDesc(number, pageRequest);
	}
}
