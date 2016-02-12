package com.ynyes.fayl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 招聘岗位实体类
 * 
 * @author DengXiao
 */
@Entity
public class TdJob {

	public TdJob() {
		super();
	}

	public TdJob(Long id, String number, String title, String introduction, String content, String seoTitle,
			String seoKeywords, String seoContent) {
		super();
		this.id = id;
		this.number = number;
		this.title = title;
		this.introduction = introduction;
		this.content = content;
		this.seoTitle = seoTitle;
		this.seoKeywords = seoKeywords;
		this.seoContent = seoContent;
		this.sortId = 99.9;
		this.createTime = new Date();
	}

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 岗位编号（唯一标识）
	@Column(unique = true)
	private String number;

	// 岗位标题
	@Column
	private String title;

	// 简介
	@Column(length = 255)
	private String introduction;

	// 内容
	@Column(length = 255)
	private String content;

	// 发布日期
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	// 排序号
	@Column
	private Double sortId;

	// SEO标题
	@Column
	private String seoTitle;

	// SEO关键字
	@Column(length = 255)
	private String seoKeywords;

	// SEO描述
	@Column(length = 255)
	private String seoContent;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getSeoContent() {
		return seoContent;
	}

	public void setSeoContent(String seoContent) {
		this.seoContent = seoContent;
	}

	@Override
	public String toString() {
		return "TdJob [id=" + id + ", number=" + number + ", title=" + title + ", introduction=" + introduction
				+ ", content=" + content + ", createTime=" + createTime + ", sortId=" + sortId + ", seoTitle="
				+ seoTitle + ", seoKeywords=" + seoKeywords + ", seoContent=" + seoContent + "]";
	}
}
