package com.allbareun.web.entity;

public class Participation {
	private int goalId;
	private int id;
	private int userId;
	
	
	public Participation(int goalId, int id, int userId) {
		super();
		this.goalId = goalId;
		this.id = id;
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


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Participation [goalId=" + goalId + ", id=" + id + ", userId=" + userId + "]";
	}
	
	
}
