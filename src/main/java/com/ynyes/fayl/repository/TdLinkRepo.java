package com.ynyes.fayl.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdLink;

public interface TdLinkRepo extends PagingAndSortingRepository<TdLink, Long>, JpaSpecificationExecutor<TdLink> {

	/**
	 * 根据指定的友情链接编号查找
	 * 
	 * @author DengXiao
	 */
	TdLink findByNumber(String number);

	/**
	 * 根据标题查找友情链接
	 * 
	 * @author DengXiao
	 */
	TdLink findByTitle(String title);

	TdLink findByTitleAndIdNot(String title, Long id);
}
