package com.allbareun.web.entity;

import java.util.Date;

public class Certification {
	
	private int goalId; 
	private int id;
	private String image;
	private Date regDate;
	private int userId;
	
	
	public Certification(int goalId, int id, String image, Date regDate, int userId) {
		super();
		this.goalId = goalId;
		this.id = id;
		this.image = image;
		this.regDate = regDate;
		this.userId = userId;
	}


	public int getGoalId() {
		return goalId;
	}


	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Certification [goalId=" + goalId + ", id=" + id + ", image=" + image + ", regDate=" + regDate
				+ ", userId=" + userId + "]";
	}
	
	
	
}
