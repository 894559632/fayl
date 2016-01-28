package com.ynyes.fayl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 广告分类实体类
 * 
 * @author dengxiao
 *
 */

@Entity
public class TdAdType {

	public TdAdType() {
		super();
	}

	public TdAdType(String number, String title, Boolean isNewWindow) {
		super();
		this.number = number;
		this.title = title;
		this.isNewWindow = isNewWindow;
		this.createDate = new Date();
		this.sortId = 99.9;
	}

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 分类编号（唯一标识）
	@Column(unique = true)
	private String number;

	// 分类名称
	@Column
	private String title;

	// 是否在新窗口显示
	@Column
	private Boolean isNewWindow;

	// 创建时间
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;

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

	public Boolean getIsNewWindow() {
		return isNewWindow;
	}

	public void setIsNewWindow(Boolean isNewWindow) {
		this.isNewWindow = isNewWindow;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Double getSortId() {
		return sortId;
	}

	public void setSortId(Double sortId) {
		this.sortId = sortId;
	}

	@Override
	public String toString() {
		return "TdAdType [id=" + id + ", number=" + number + ", title=" + title + ", isNewWindow=" + isNewWindow
				+ ", createDate=" + createDate + ", sortId=" + sortId + "]";
	}
}
