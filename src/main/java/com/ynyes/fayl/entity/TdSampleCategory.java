package com.ynyes.fayl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * 案例分类实体类
 * 
 * @author dengxiao
 *
 */

@Entity
public class TdSampleCategory {

	public TdSampleCategory() {
		super();
	}

	public TdSampleCategory(String number, String title, String description, String seoTitle, String seoKeywords,
			String seoDescription) {
		super();
		this.number = number;
		this.title = title;
		this.description = description;
		this.seoTitle = seoTitle;
		this.seoKeywords = seoKeywords;
		this.seoDescription = seoDescription;
		this.sortId = 99.9;
	}

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 案例分类编号（唯一标识）
	@Column(unique = true)
	private String number;

	// 分类名称
	@Column
	private String title;

	// 分类描述
	@Column(length = 255)
	private String description;

	// SEO标题
	@Column
	private String seoTitle;

	// SEO关键字
	@Column(length = 255)
	private String seoKeywords;

	// SEO描述
	@Column(length = 255)
	private String seoDescription;

	// 排序号
	@Column(scale = 2)
	private Double sortId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Double getSortId() {
		return sortId;
	}

	public void setSortId(Double sortId) {
		this.sortId = sortId;
	}

	@Override
	public String toString() {
		return "TdSampleCategory [id=" + id + ", number=" + number + ", title=" + title + ", description=" + description
				+ ", seoTitle=" + seoTitle + ", seoKeywords=" + seoKeywords + ", seoDescription=" + seoDescription
				+ ", sortId=" + sortId + "]";
	}
}
