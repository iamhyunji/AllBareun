package com.allbareun.web.entity;

public class GoalCategory {

	private int id;
	private int goalId;
	private int goalCategoryTypeId;
	private int priority;
	
	public GoalCategory() {
		// TODO Auto-generated constructor stub
	}

	public GoalCategory(int id, int goalId, int goalCategoryTypeId, int priority) {
		super();
		this.id = id;
		this.goalId = goalId;
		this.goalCategoryTypeId = goalCategoryTypeId;
		this.priority = priority;
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

	public int getGoalCategoryTypeId() {
		return goalCategoryTypeId;
	}

	public void setGoalCategoryTypeId(int goalCategoryTypeId) {
		this.goalCategoryTypeId = goalCategoryTypeId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "GoalCategory [id=" + id + ", goalId=" + goalId + ", goalCategoryTypeId=" + goalCategoryTypeId
				+ ", priority=" + priority + "]";
	}
	
	
}
