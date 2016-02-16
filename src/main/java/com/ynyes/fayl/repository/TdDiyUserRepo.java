package com.ynyes.fayl.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ynyes.fayl.entity.TdDiyUser;

public interface TdDiyUserRepo
		extends PagingAndSortingRepository<TdDiyUser, Long>, JpaSpecificationExecutor<TdDiyUser> {

	// 根据账号和密码查找用户
	TdDiyUser findByUsernameAndPasswordAndIsEnableTrue(String username, String password);

	// 根据停车场ID和角色ID查找子账号
	List<TdDiyUser> findByDiyIdAndRoleId(Long diyId, Long roleId);
	
	//根据用户名查找用户
	TdDiyUser findByUsername(String username);
	
	//zhangji 车库账户页
	Page<TdDiyUser> findByIsEnableTrue(Pageable page);
	
	//zhangji 车库账户关键字搜索
	Page<TdDiyUser> findByIsEnableTrueAndRealNameContainingOrIsEnableTrueAndUsernameContaining
		(String keywords , String keywords2 , Pageable page);
	
	Page<TdDiyUser> findByRealNameContainingOrUsernameContaining
	(String keywords , String keywords2 , Pageable page);
}
