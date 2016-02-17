package com.ynyes.fayl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 案例实体类
 * 
 * @author dengxiao
 * 
 */

@Entity
public class TdSample {

	public TdSample() {
		super();
	}

	public TdSample(String number, String categoryNumber, String categoryTitle, String title, String designer,
			String coverImgUri, String imgUriList, String introduction, String content, Boolean isIndexRecommend,
			String seoTitle, String seoKeywords, String seoDescription) {
		super();
		this.number = number;
		this.categoryNumber = categoryNumber;
		this.categoryTitle = categoryTitle;
		this.title = title;
		this.designer = designer;
		this.coverImgUri = coverImgUri;
		this.imgUriList = imgUriList;
		this.introduction = introduction;
		this.content = content;
		this.isIndexRecommend = isIndexRecommend;
		this.seoTitle = seoTitle;
		this.seoKeywords = seoKeywords;
		this.seoDescription = seoDescription;
		this.designDate = new Date();
		this.sortId = 99.9;
	}

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 案例编号（唯一标识）
	@Column(unique = true)
	private String number;

	// 案例分类编号哦
	@Column
	private String categoryNumber;

	// 案例分类名称
	@Column
	private String categoryTitle;

	// 案例标题
	@Column
	private String title;

	// 设计师名称
	@Column
	private String designer;

	// 封面图
	@Column
	private String coverImgUri;

	// 案例图片（多张以，隔开）
	@Column(length = 255)
	private String imgUriList;

	// 案例简介
	@Column
	private String introduction;

	// 案例详情
	@Column
	private String content;

	// 是否首页推荐
	@Column
	private Boolean isIndexRecommend;

	// 设计时间
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date designDate;

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

	public String getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(String categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
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

	public Boolean getIsIndexRecommend() {
		return isIndexRecommend;
	}

	public void setIsIndexRecommend(Boolean isIndexRecommend) {
		this.isIndexRecommend = isIndexRecommend;
	}

	public Date getDesignDate() {
		return designDate;
	}

	public void setDesignDate(Date designDate) {
		this.designDate = designDate;
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
		return "TdSample [id=" + id + ", number=" + number + ", categoryNumber=" + categoryNumber + ", categoryTitle="
				+ categoryTitle + ", title=" + title + ", designer=" + designer + ", coverImgUri=" + coverImgUri
				+ ", imgUriList=" + imgUriList + ", introduction=" + introduction + ", content=" + content
				+ ", isIndexRecommend=" + isIndexRecommend + ", designDate=" + designDate + ", seoTitle=" + seoTitle
				+ ", seoKeywords=" + seoKeywords + ", seoDescription=" + seoDescription + ", sortId=" + sortId + "]";
	}
}
