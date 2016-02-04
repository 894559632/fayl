package com.ynyes.fayl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 广告实体类
 * 
 * @author dengxiao
 *
 */

@Entity
public class TdAd {

	public TdAd() {
		super();
	}

	public TdAd(String number, String introduce, String imgUri, String categoryNumber, String categoryTitle,
			Boolean isEnable, Date startTime, Date endTime, String linkUri) {
		super();
		this.number = number;
		this.introduce = introduce;
		this.imgUri = imgUri;
		this.categoryNumber = categoryNumber;
		this.categoryTitle = categoryTitle;
		this.isEnable = isEnable;
		this.startTime = startTime;
		this.endTime = endTime;
		this.linkUri = linkUri;
		this.sortId = 99.9;
	}

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 广告编号（唯一标识）
	@Column(unique = true)
	private String number;

	// 广告简介
	@Column
	private String introduce;

	// 广告图片
	@Column
	private String imgUri;

	// 分类编号
	@Column
	private String categoryNumber;

	// 分类名称
	@Column
	private String categoryTitle;

	// 是否生效
	@Column
	private Boolean isEnable;

	// 有效起始时间
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	// 有效截止时间
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	// 链接地址
	@Column
	private String linkUri;

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

	public String getIntroduce() {
		return introduce;
	}

	public String getCategoryNumber() {
		return categoryNumber;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public void setCategoryNumber(String categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}

	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getLinkUri() {
		return linkUri;
	}

	public void setLinkUri(String linkUri) {
		this.linkUri = linkUri;
	}

	public Double getSortId() {
		return sortId;
	}

	public void setSortId(Double sortId) {
		this.sortId = sortId;
	}

	@Override
	public String toString() {
		return "TdAd [id=" + id + ", number=" + number + ", introduce=" + introduce + ", imgUri=" + imgUri
				+ ", categoryNumber=" + categoryNumber + ", categoryTitle=" + categoryTitle + ", isEnable=" + isEnable
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", linkUri=" + linkUri + ", sortId=" + sortId
				+ "]";
	}
}
