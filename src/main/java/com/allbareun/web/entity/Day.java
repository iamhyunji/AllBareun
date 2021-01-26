package com.allbareun.web.entity;

public class Day {
	private int id;
	private String dayName;
	
	public Day() {
		// TODO Auto-generated constructor stub
	}

	public Day(int id, String dayName) {
		super();
		this.id = id;
		this.dayName = dayName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	@Override
	public String toString() {
		return "Day [id=" + id + ", dayName=" + dayName + "]";
	}
	
	
}
