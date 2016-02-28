package com.ynyes.fayl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 设计师实体类
 * 
 * @author dengxiao
 */
@Entity
public class TdDesigner {

	public TdDesigner() {
		super();
	}

	public TdDesigner(String number, String position, String name, String photoUri, String description, String seoTitle,
			String seoKeywords, String seoDescription) {
		super();
		this.number = number;
		this.position = position;
		this.name = name;
		this.photoUri = photoUri;
		this.description = description;
		this.seoTitle = seoTitle;
		this.seoKeywords = seoKeywords;
		this.seoDescription = description;
	}

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 设计师编号（唯一标识）
	@Column(unique = true)
	private String number;

	// 设计师职位
	@Column
	private String position;

	// 设计师姓名
	@Column
	private String name;

	// 照片
	@Column
	private String photoUri;

	// 设计师简介
	@Column
	private String description;

	// SEO标题
	@Column
	private String seoTitle;

	// SEO关键词
	@Column
	private String seoKeywords;

	// SEO描述
	@Column
	private String seoDescription;

	// 排序号
	@Column
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoUri() {
		return photoUri;
	}

	public void setPhotoUri(String photoUri) {
		this.photoUri = photoUri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getSortId() {
		return sortId;
	}

	public void setSortId(Double sortId) {
		this.sortId = sortId;
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
		return "TdDesigner [id=" + id + ", number=" + number + ", position=" + position + ", name=" + name
				+ ", photoUri=" + photoUri + ", description=" + description + ", seoTitle=" + seoTitle
				+ ", seoKeywords=" + seoKeywords + ", seoDescription=" + seoDescription + ", sortId=" + sortId + "]";
	}
}
