package com.ynyes.fayl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 网站留言实体类
 * 
 * @author DengXiao
 */

@Entity
public class TdRemark {

	public TdRemark() {
		super();
		this.remarkDate = new Date();
		this.sortId = 99.9;
	}

	public TdRemark(String number, String name, String phone, String email, String content, Long type) {
		super();
		this.number = number;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.content = content;
		this.type = type;
		this.remarkDate = new Date();
		this.sortId = 99.9;
	}

	// 自增主键
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 留言编号
	@Column(unique = true)
	private String number;

	// 留言人
	@Column
	private String name;

	// 联系电话
	@Column
	private String phone;

	// 邮箱地址
	@Column(length = 255)
	private String email;

	// 留言内容
	@Column(length = 255)
	private String content;

	// 留言时间
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date remarkDate;

	// 类型：1. PC留言；2. 微网站（触屏）留言
	@Column
	private Long type;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRemarkDate() {
		return remarkDate;
	}

	public void setRemarkDate(Date remarkDate) {
		this.remarkDate = remarkDate;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Double getSortId() {
		return sortId;
	}

	public void setSortId(Double sortId) {
		this.sortId = sortId;
	}

	@Override
	public String toString() {
		return "TdRemark [id=" + id + ", number=" + number + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", content=" + content + ", remarkDate=" + remarkDate + ", type=" + type + ", sortId=" + sortId + "]";
	}

}
