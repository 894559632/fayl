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

	public TdDesigner(String number, String position, String name, String photoUri) {
		super();
		this.number = number;
		this.position = position;
		this.name = name;
		this.photoUri = photoUri;
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

	public Double getSortId() {
		return sortId;
	}

	public void setSortId(Double sortId) {
		this.sortId = sortId;
	}

	@Override
	public String toString() {
		return "TdDesigner [id=" + id + ", number=" + number + ", position=" + position + ", name=" + name
				+ ", photoUri=" + photoUri + ", sortId=" + sortId + "]";
	}
}
