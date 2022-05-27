package com.fincons.academy.TodoBE.dto;

import java.sql.Date;

public class TodoDto {
	
	private Integer id;
	private String text;
	private String state;
	private Date createdAt;
	private Date dueTo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getDueTo() {
		return dueTo;
	}
	public void setDueTo(Date dueTo) {
		this.dueTo = dueTo;
	}
	

}
