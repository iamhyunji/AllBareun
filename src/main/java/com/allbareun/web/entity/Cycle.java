package com.allbareun.web.entity;

public class Cycle {
	private int id;
	private int goalId;
	private int dayId;
	
	public Cycle() {
		// TODO Auto-generated constructor stub
	}

	public Cycle(int id, int goalId, int dayId) {
		super();
		this.id = id;
		this.goalId = goalId;
		this.dayId = dayId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoalId() {
		return goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	public int getDayId() {
		return dayId;
	}

	public void setDayId(int dayId) {
		this.dayId = dayId;
	}

	@Override
	public String toString() {
		return "Cycle [id=" + id + ", goalId=" + goalId + ", dayId=" + dayId + "]";
	}
	
	
}
