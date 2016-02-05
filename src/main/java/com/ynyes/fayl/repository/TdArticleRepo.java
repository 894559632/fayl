package com.ynyes.fayl.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdArticle;

public interface TdArticleRepo
		extends PagingAndSortingRepository<TdArticle, Long>, JpaSpecificationExecutor<TdArticle> {

	/**
	 * 根据分类编号查找文章，按照排序号正序排序（不分页）
	 * 
	 * @author dengxiao
	 */
	List<TdArticle> findByCategoryNumberOrderBySortIdAsc(String number);

	/**
	 * 根据分类编号查找文章，按照排序号正序排序（分页）
	 * 
	 * @author dengxiao
	 */
	Page<TdArticle> findByCategoryNumberOrderBySortIdAsc(String number, Pageable page);

	/**
	 * 根据分类编号查找文章，按照生成时间反序排序（不分页）
	 * 
	 * @author dengxiao
	 */
	List<TdArticle> findByCategoryNumberOrderByCreateDateDesc(String number);

	/**
	 * 根据分类编号查找文章，按照生成时间反序排序（分页）
	 * 
	 * @author dengxiao
	 */
	Page<TdArticle> findByCategoryNumberOrderByCreateDateDesc(String number, Pageable page);

	/**
	 * 根据编号查找指定的文章
	 * 
	 * @author DengXiao
	 */
	TdArticle findByNumber(String number);
}
