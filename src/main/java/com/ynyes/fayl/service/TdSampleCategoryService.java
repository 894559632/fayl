package com.ynyes.fayl.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynyes.fayl.entity.TdSampleCategory;
import com.ynyes.fayl.repository.TdSampleCategoryRepo;


@Service
@Transactional
public class TdSampleCategoryService {

	@Autowired
	private TdSampleCategoryRepo repository;
	
	public TdSampleCategory save(TdSampleCategory e){
		if(null == e){
			return e;
		}
		return repository.save(e);
	}
	
	public void delete(Long id){
		if(null != id){
			repository.delete(id);
		}
	}
	
	public TdSampleCategory findOne(Long id){
		if(null == id){
			return null;
		}
		return repository.findOne(id);
	}
	
	public List<TdSampleCategory> findAll(){
		return (List<TdSampleCategory>) repository.findAll();
	}
	/**
	 * 根据查询编号查找到指定的案例分类
	 * 
	 * @author DengXiao
	 */
	public TdSampleCategory findByNumber(String number){
		if(null == number){
			return null;
		}
		return repository.findByNumber(number);
	}
}
