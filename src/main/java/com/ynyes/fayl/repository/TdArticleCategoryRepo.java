package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdArticleCategory;

public interface TdArticleCategoryRepo
		extends PagingAndSortingRepository<TdArticleCategory, Long>, JpaSpecificationExecutor<TdArticleCategory> {

	/**
	 * 根据分类编号查找分类
	 * 
	 * @author dengxiao
	 */
	TdArticleCategory findByNumber(String number);

	/**
	 * 根据分类名称查找分类
	 * 
	 * @author dengxiao
	 */
	TdArticleCategory findByTitle(String title);
}
