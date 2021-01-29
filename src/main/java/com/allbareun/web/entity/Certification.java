package com.allbareun.web.entity;

import java.util.Date;

public class Certification {
	
	private int goalId; 
	private int id;
	private String authImage;
	private Date regdate;
	private int userId;
	
	
public Certification() {
	// TODO Auto-generated constructor stub
}


public Certification(int goalId, int id, String authImage, Date regdate, int userId) {
	super();
	this.goalId = goalId;
	this.id = id;
	this.authImage = authImage;
	this.regdate = regdate;
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


public String getAuthImage() {
	return authImage;
}


public void setAuthImage(String authImage) {
	this.authImage = authImage;
}


public Date getRegdate() {
	return regdate;
}


public void setRegdate(Date regdate) {
	this.regdate = regdate;
}


public int getUserId() {
	return userId;
}


public void setUserId(int userId) {
	this.userId = userId;
}


@Override
public String toString() {
	return "Certification [goalId=" + goalId + ", id=" + id + ", authImage=" + authImage + ", regdate=" + regdate
			+ ", userId=" + userId + "]";
}



	
	
}
