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

	public static void setInstance(TdCompany company) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroductonNumber() {
		return introductonNumber;
	}

	public void setIntroductonNumber(String introductonNumber) {
		this.introductonNumber = introductonNumber;
	}

	public String getDelvelopmentNumber() {
		return delvelopmentNumber;
	}

	public void setDelvelopmentNumber(String delvelopmentNumber) {
		this.delvelopmentNumber = delvelopmentNumber;
	}

	public List<TdDesigner> getDesigners() {
		return designers;
	}

	public void setDesigners(List<TdDesigner> designers) {
		this.designers = designers;
	}

	public String getSeoTitle() {
		return seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	@Override
	public String toString() {
		return "TdCompany [id=" + id + ", title=" + title + ", introductonNumber=" + introductonNumber
				+ ", delvelopmentNumber=" + delvelopmentNumber + ", designers=" + designers + ", seoTitle=" + seoTitle
				+ ", seoKeywords=" + seoKeywords + ", seoDescription=" + seoDescription + "]";
	}
}
