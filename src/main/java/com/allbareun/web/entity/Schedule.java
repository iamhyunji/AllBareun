package com.allbareun.web.entity;

import java.util.Date;

public class Schedule {
	private int id;
	private String userId;
	private Date regDate;
	private String regContent;
	private String color;
	
	public Schedule(int id, String userId, Date regDate, String regContent, String color) {
		super();
		this.id = id;
		this.userId = userId;
		this.regDate = regDate;
		this.regContent = regContent;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRegContent() {
		return regContent;
	}

	public void setRegContent(String regContent) {
		this.regContent = regContent;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "schedule [id=" + id + ", userId=" + userId + ", regDate=" + regDate + ", regContent=" + regContent
				+ ", color=" + color + "]";
	}
	
	
}
