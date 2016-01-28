package com.ynyes.fayl.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * 公司实体类
 * 
 * @author dengxiao
 */
@Entity
public class TdCompany {

	/*--------------------单例模式----------------------*/
	private static TdCompany INSTANCE = new TdCompany();

	private TdCompany() {
		super();
	}

	public static TdCompany getInstance() {
		return INSTANCE;
	}
	
	public static void setInstance(TdCompany company){
		INSTANCE = company;
	}
	/*-----------------------------------------------*/

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 公司名称
	@Column
	private String title;

	// 公司介绍（引用公司信息编号）
	@Column
	private String introductonNumber;

	// 发展愿景（引用公司信息编号）
	@Column
	private String delvelopmentNumber;

	// 设计团队
	@OneToMany
	@JoinColumn(name = "companyId")
	private List<TdDesigner> designers;

	// SEO标题
	@Column
	private String seoTitle;

	// SEO关键字
	@Column
	private String seoKeywords;

	// SEO描述
	@Column
	private String seoDescription;

}
