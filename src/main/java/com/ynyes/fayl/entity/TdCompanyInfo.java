package com.ynyes.fayl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 公司信息实体类
 * 
 * @author dengxiao
 */
@Entity
public class TdCompanyInfo {

	public TdCompanyInfo() {
		super();
	}

	public TdCompanyInfo(String number, String title, String content) {
		super();
		this.number = number;
		this.title = title;
		this.content = content;
		this.isEnable = true;
		this.sortId = 99.9;
	}

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 公司信息编号（唯一标识）
	@Column(unique = true)
	private String number;

	// 公司信息标题
	@Column
	private String title;

	// 公司信息内容
	@Column(length = 255)
	private String content;

	// 是否启用
	@Column
	private Boolean isEnable;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	public Double getSortId() {
		return sortId;
	}

	public void setSortId(Double sortId) {
		this.sortId = sortId;
	}

	@Override
	public String toString() {
		return "TdCompanyInfo [id=" + id + ", number=" + number + ", title=" + title + ", content=" + content
				+ ", isEnable=" + isEnable + ", sortId=" + sortId + "]";
	}
}
