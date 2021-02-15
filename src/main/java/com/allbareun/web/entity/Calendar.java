package com.allbareun.web.entity;

import java.util.Date;

public class Calendar {
	private int id;
	private int userId;
	private Date regDate;
	private Date start;
	private Date end;
	private String title;
	private String type;
	private String description;
	private String textColor;
	private boolean allDay;
	private String backgroundColor;
	
	
    public Calendar() {
		// TODO Auto-generated constructor stub
	}


	public Calendar(int id, int userId, Date regDate, Date start, Date end, String title, String type,
			String description, String textColor, boolean allDay, String backgroundColor) {
		super();
		this.id = id;
		this.userId = userId;
		this.regDate = regDate;
		this.start = start;
		this.end = end;
		this.title = title;
		this.type = type;
		this.description = description;
		this.textColor = textColor;
		this.allDay = allDay;
		this.backgroundColor = backgroundColor;
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


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}


	public Date getEnd() {
		return end;
	}


	public void setEnd(Date end) {
		this.end = end;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getTextColor() {
		return textColor;
	}


	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}


	public boolean isAllDay() {
		return allDay;
	}


	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}


	public String getBackgroundColor() {
		return backgroundColor;
	}


	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}


	@Override
	public String toString() {
		return "Calendar [id=" + id + ", userId=" + userId + ", regDate=" + regDate + ", start=" + start + ", end="
				+ end + ", title=" + title + ", type=" + type + ", description=" + description + ", textColor="
				+ textColor + ", allDay=" + allDay + ", backgroundColor=" + backgroundColor + "]";
	}


	
	
	
}
