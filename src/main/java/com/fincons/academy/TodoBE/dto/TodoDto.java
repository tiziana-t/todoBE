package com.fincons.academy.TodoBE.dto;

public class TodoDto {
	
	private Integer id;
	private String text;
	private String state;
	private String createdAt;
	private String dueTo;
	
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getDueTo() {
		return dueTo;
	}
	public void setDueTo(String dueTo) {
		this.dueTo = dueTo;
	}
	

}
