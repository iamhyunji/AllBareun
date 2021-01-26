package com.allbareun.web.entity;

public class GoalCategoryType {

	private int id;
	private String color;
	private String title;
	
	public GoalCategoryType() {
		// TODO Auto-generated constructor stub
	}

	public GoalCategoryType(int id, String color, String title) {
		super();
		this.id = id;
		this.color = color;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "GoalCategoryType [id=" + id + ", color=" + color + ", title=" + title + "]";
	}
	
	
}
