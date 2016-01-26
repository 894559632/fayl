package com.ynyes.fayl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 文章实体类
 * 
 * @author dengxiao
 *
 */

@Entity
public class TdArticle {

	public TdArticle() {
		super();
	}

	public TdArticle(Long id, String number, String categoryNumber, String title, String author, String imgUri,
			String content, String seoTitle, String seoKeywords, String seoDescription) {
		super();
		this.id = id;
		this.number = number;
		this.categoryNumber = categoryNumber;
		this.title = title;
		this.author = author;
		this.imgUri = imgUri;
		this.content = content;
		this.seoTitle = seoTitle;
		this.seoKeywords = seoKeywords;
		this.seoDescription = seoDescription;
		this.createDate = new Date();
		this.sortId = 99.9;
	}

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 文章编号（唯一标识）
	@Column(unique = true)
	private String number;

	// 文章分类编号（文章分类的编号）
	@Column
	private String categoryNumber;

	// 文章的标题
	@Column
	private String title;

	// 文章的作者
	@Column
	private String author;

	// 文章的图片
	@Column
	private String imgUri;

	// 文章的内容
	@Column(length = 255)
	private String content;

	// 文章生成的时间
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
		return "TdArticle [id=" + id + ", number=" + number + ", categoryNumber=" + categoryNumber + ", title=" + title
				+ ", author=" + author + ", imgUri=" + imgUri + ", content=" + content + ", createDate=" + createDate
				+ ", seoTitle=" + seoTitle + ", seoKeywords=" + seoKeywords + ", seoDescription=" + seoDescription
				+ ", sortId=" + sortId + "]";
	}
}
