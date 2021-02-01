package com.allbareun.web.entity;

import java.util.Date;

public class GoalAllView extends Goal {
	private int dateDiff;
	private String userName;
	private String categories;
	private String days;
	private String participants;
	private String groupParticipants;

    // --------------------------------- Constructor ---------------------------------
	public GoalAllView() {
		
	}

	public GoalAllView(int id, String title, String explanation, String mainImage, String goodEx, String badEx,
			Date endDate, Date startDate, boolean publicStatus, Date regdate, int count, int userId,
			int totalParticipants, int dateDiff, String userName, String categories, String days, String participants,
			String groupParticipants) {
		super(id, title, explanation, mainImage, goodEx, badEx, endDate, startDate, publicStatus, regdate, count,
				userId, totalParticipants);
		this.dateDiff = dateDiff;
		this.userName = userName;
		this.categories = categories;
		this.days = days;
		this.participants = participants;
		this.groupParticipants = groupParticipants;
	}
	
	// --------------------------------- Getters/Setters ---------------------------------
	public int getDateDiff() {
		return dateDiff;
	}

	public void setDateDiff(int dateDiff) {
		this.dateDiff = dateDiff;
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

	public String getGroupParticipants() {
		return groupParticipants;
	}

	public void setGroupParticipants(String groupParticipants) {
		this.groupParticipants = groupParticipants;
	}
	
	// --------------------------------- Function ---------------------------------
	@Override
	public String toString() {
		return "GoalAllView [dateDiff=" + dateDiff + ", userName=" + userName + ", categories=" + categories + ", days="
				+ days + ", participants=" + participants + ", groupParticipants=" + groupParticipants + ", getId()="
				+ getId() + ", getTitle()=" + getTitle() + ", getExplanation()=" + getExplanation()
				+ ", getMainImage()=" + getMainImage() + ", getGoodEx()=" + getGoodEx() + ", getBadEx()=" + getBadEx()
				+ ", getEndDate()=" + getEndDate() + ", getStartDate()=" + getStartDate() + ", getPublicStatus()="
				+ getPublicStatus() + ", getRegdate()=" + getRegdate() + ", getCount()=" + getCount() + ", getUserId()="
				+ getUserId() + ", getTotalParticipants()=" + getTotalParticipants() + ", getExExplanation()="
				+ getExExplanation() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
