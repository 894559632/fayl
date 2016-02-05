package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	 * @author DengXiao
	 */
	public List<TdArticle> findByCategoryNumberOrderBySortIdAsc(String number) {
		if (null == number) {
			return null;
		}
		return repository.findByCategoryNumberOrderBySortIdAsc(number);
	}

	/**
	 * 根据分类编号查找文章，按照排序号正序排序（分页）
	 * 
	 * @author DengXiao
	 */
	public Page<TdArticle> findByCategoryNumberOrderBySortIdAsc(String number, int page, int size) {
		if (null == number) {
			return null;
		}
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByCategoryNumberOrderBySortIdAsc(number, pageRequest);
	}

	/**
	 * 根据分类编号查找文章，按照生成时间反序排序（不分页）
	 * 
	 * @author DengXiao
	 */
	public List<TdArticle> findByCategoryNumberOrderByCreateDateDesc(String number) {
		if (null == number) {
			return null;
		}
		return repository.findByCategoryNumberOrderByCreateDateDesc(number);
	}

	/**
	 * 根据分类编号查找文章，按照生成时间反序排序（分页）
	 * 
	 * @author DengXiao
	 */
	public Page<TdArticle> findByCategoryNumberOrderByCreateDateDesc(String number, int page, int size) {
		if (null == number) {
			return null;
		}
		PageRequest pageRequest = new PageRequest(page, size);
		return repository.findByCategoryNumberOrderByCreateDateDesc(number, pageRequest);
	}

	/**
	 * 查找所有文章，按照生成时间反序排序（分页）
	 * 
	 * @author DengXiao
	 */
	public Page<TdArticle> findAll(int page, int size) {
		PageRequest pageRequest = new PageRequest(page, size, new Sort(Direction.DESC, "createDate"));
		return repository.findAll(pageRequest);
	}

	/**
	 * 根据编号查找指定的文章
	 * 
	 * @author DengXiao
	 */
	public TdArticle findByNumber(String number){
		if(null == number){
			return null;
		}
		return repository.findByNumber(number);
	}
}
