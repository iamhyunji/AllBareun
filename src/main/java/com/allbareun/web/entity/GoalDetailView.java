package com.allbareun.web.entity;

import java.util.Date;

public class GoalDetailView extends GoalView{
	private String userName;
	private String categories;
	private String days;
	private String participants;
	private String profile;
	private String exExplanation;
	private String goodEx;
	private String badEx;

	
	public GoalDetailView() {
		// TODO Auto-generated constructor stub
	}

	public GoalDetailView(int id, String title, String mainImage, Date endDate, Date startDate, int dateDiff,
			boolean publicStatus, Date regdate, int count, String userName, String categories, String days,
			int totalParticipants, int nowParticipantsCount, String categoriesColor, String exExplanation,
			String participants,String profile,String goodEx,String badEx) {
		super(id, title, mainImage, endDate, startDate, dateDiff, publicStatus, regdate, count, userName, categories,
				days, totalParticipants, nowParticipantsCount, categoriesColor);
	
		this.exExplanation = exExplanation;
		this.goodEx = goodEx;
		this.badEx = badEx;
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
	
	

	public String getExExplanation() {
		return exExplanation;
	}

	public void setExExplanation(String exExplanation) {
		this.exExplanation = exExplanation;
	}

	public String getGoodEx() {
		return goodEx;
	}

	public void setGoodEx(String goodEx) {
		this.goodEx = goodEx;
	}

	public String getBadEx() {
		return badEx;
	}

	public void setBadEx(String badEx) {
		this.badEx = badEx;
	}

	@Override
	public String toString() {
		return "GoalDetailView [userName=" + userName + ", categories=" + categories + ", days=" + days
				+ ", participants=" + participants + ", profile=" + profile + ", getId()=" + getId() + ", getTitle()="
				+ getTitle() + ", getExExplanation()=" + getExExplanation() + ", getMainImage()=" + getMainImage()
				+ ", getGoodEx()=" + getGoodEx() + ", getBadEx()=" + getBadEx() + ", getEndDate()=" + getEndDate()
				+ ", getStartDate()=" + getStartDate() + ", getRegdate()="
				+ getRegdate() + ", getCount()=" + getCount() 
				+ ", getTotalParticipants()=" + getTotalParticipants() 
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
