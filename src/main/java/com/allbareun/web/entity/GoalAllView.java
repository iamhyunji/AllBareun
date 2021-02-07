package com.allbareun.web.entity;

import java.util.Date;

public class GoalAllView extends Goal {
	private String categories;
	private String categoriesColor;
    private String days;
    private String participantIds;
    private String participants;
    private String profiles;
    private int dateDiff;
    
    // --------------------------------- Constructor ---------------------------------
    public GoalAllView() {
    	
	}

	public GoalAllView(int id, String title, String explanation, String mainImage, String goodEx, String badEx,
			Date endDate, Date startDate, boolean publicStatus, Date regdate, int count, int userId,
			int totalParticipants, String exExplanation, String categories, String categoriesColor, String days,
			String participantIds, String participants, String profiles, int dateDiff) {
		super(id, title, explanation, mainImage, goodEx, badEx, endDate, startDate, publicStatus, regdate, count,
				userId, totalParticipants, exExplanation);
		this.categories = categories;
		this.categoriesColor = categoriesColor;
		this.days = days;
		this.participantIds = participantIds;
		this.participants = participants;
		this.profiles = profiles;
		this.dateDiff = dateDiff;
	}

	// --------------------------------- Getters/Setters ---------------------------------
	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getCategoriesColor() {
		return categoriesColor;
	}

	public void setCategoriesColor(String categoriesColor) {
		this.categoriesColor = categoriesColor;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getParticipantIds() {
		return participantIds;
	}

	public void setParticipantIds(String participantIds) {
		this.participantIds = participantIds;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getProfiles() {
		return profiles;
	}

	public void setProfiles(String profiles) {
		this.profiles = profiles;
	}

	public int getDateDiff() {
		return dateDiff;
	}

	public void setDateDiff(int dateDiff) {
		this.dateDiff = dateDiff;
	}

	// --------------------------------- Function ---------------------------------
	@Override
	public String toString() {
		return "GoalAllView [categories=" + categories + ", categoriesColor=" + categoriesColor + ", days=" + days
				+ ", participantIds=" + participantIds + ", participants=" + participants + ", profiles=" + profiles
				+ ", dateDiff=" + dateDiff + ", getId()=" + getId() + ", getTitle()=" + getTitle()
				+ ", getExplanation()=" + getExplanation() + ", getMainImage()=" + getMainImage() + ", getGoodEx()="
				+ getGoodEx() + ", getBadEx()=" + getBadEx() + ", getEndDate()=" + getEndDate() + ", getStartDate()="
				+ getStartDate() + ", getPublicStatus()=" + getPublicStatus() + ", getRegdate()=" + getRegdate()
				+ ", getCount()=" + getCount() + ", getUserId()=" + getUserId() + ", getTotalParticipants()="
				+ getTotalParticipants() + ", getExExplanation()=" + getExExplanation() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
