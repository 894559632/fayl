package com.ynyes.fayl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 友情链接实体类
 * 
 * @author DengXiao
 */

@Entity
public class TdLink {

	public TdLink() {
		super();
	}

	public TdLink(String number, String title, String linkUri) {
		super();
		this.number = number;
		this.title = title;
		this.linkUri = linkUri;
		this.sortId = 99.9;
	}

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 链接编号（唯一标识）
	@Column(unique = true)
	private String number;

	// 链接名称
	@Column
	private String title;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "TdLink [id=" + id + ", number=" + number + ", title=" + title + ", linkUri=" + linkUri + ", sortId="
				+ sortId + "]";
	}
}
