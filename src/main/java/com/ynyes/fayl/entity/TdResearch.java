package com.ynyes.fayl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 泛奥研究实体类
 * 
 * @author DengXiao
 */

@Entity
public class TdResearch {

	public TdResearch() {
		super();
	}

	public TdResearch(String number, String title, String introduction, String content, String coverImgUri,
			String imgUriList, String seoTitle, String keywords, String seoDescription) {
		super();
		this.number = number;
		this.title = title;
		this.introduction = introduction;
		this.content = content;
		this.coverImgUri = coverImgUri;
		this.imgUriList = imgUriList;
		this.seoTitle = seoTitle;
		this.keywords = keywords;
		this.seoDescription = seoDescription;
		this.sortId = 99.9;
	}

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 编号（唯一标识）
	@Column
	private String number;

	// 标题
	@Column
	private String title;

	// 简介
	@Column(length = 255)
	private String introduction;

	// 内容
	@Column(length = 255)
	private String content;

	// 封面图片
	@Column
	private String coverImgUri;

	// 详情图
	@Column
	private String imgUriList;

	// SEO标题
	@Column
	private String seoTitle;

	// SEO关键词
	@Column
	private String keywords;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCoverImgUri() {
		return coverImgUri;
	}

	public void setCoverImgUri(String coverImgUri) {
		this.coverImgUri = coverImgUri;
	}

	public String getImgUriList() {
		return imgUriList;
	}

	public void setImgUriList(String imgUriList) {
		this.imgUriList = imgUriList;
	}

	public String getSeoTitle() {
		return seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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
		return "TdResearch [id=" + id + ", number=" + number + ", title=" + title + ", introduction=" + introduction
				+ ", content=" + content + ", coverImgUri=" + coverImgUri + ", imgUriList=" + imgUriList + ", seoTitle="
				+ seoTitle + ", keywords=" + keywords + ", seoDescription=" + seoDescription + ", sortId=" + sortId
				+ "]";
	}

}
