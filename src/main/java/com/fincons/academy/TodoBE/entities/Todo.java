package com.fincons.academy.TodoBE.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo implements Serializable{
	
	private static final long serialVersionUID = -7004164929167089473L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "todotext")
	private String text;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "createdat")
	private String createdAt;
	
	@Column(name = "dueto")
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
