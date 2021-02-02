package com.allbareun.web.entity;

import java.util.Date;

public class GoalDetailView extends Goal{
	private String userName;
	private String categories;
	private String days;
	private String participants;
	private String profile;

	
	public GoalDetailView() {
		// TODO Auto-generated constructor stub
	}

	public GoalDetailView(int id, String title, String explanation, String mainImage, String goodEx, String badEx,
						Date endDate, Date startDate, boolean publicStatus, Date regdate, int count, int userId, int totalParticipants,
						String exExplanation, String userName, String categories, String days, String participants, String profile) {
		
		super(id, title, explanation, mainImage, goodEx, badEx, endDate, startDate, publicStatus, regdate, count, userId, totalParticipants,exExplanation);
		
		this.userName = userName;
		this.categories = categories;
		this.days = days;
		this.participants = participants;
		this.profile = profile;
	}
	
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	
	

}
