package com.allbareun.web.entity;

import java.util.Date;

public class Goal {
	private int id;
    private String title;
    private String explanation;
    private String mainImage;
    private String goodEx;
    private String badEx;
    private Date endDate;
    private Date startDate;
    private boolean publicStatus;
    private Date regdate;
    private int count;
    private int userId;
    private int totalParticipants;
    
    public Goal() {
		this(0, null, null, null, null, null, null, null, false, null, 0, 0, 0);
	}

	public Goal(int id, String title, String explanation, String mainImage, String goodEx, String badEx, Date endDate,
			Date startDate, boolean publicStatus, Date regdate, int count, int userId, int totalParticipants) {
		this.id = id;
		this.title = title;
		this.explanation = explanation;
		this.mainImage = mainImage;
		this.goodEx = goodEx;
		this.badEx = badEx;
		this.endDate = endDate;
		this.startDate = startDate;
		this.publicStatus = publicStatus;
		this.regdate = regdate;
		this.count = count;
		this.userId = userId;
		this.totalParticipants = totalParticipants;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean isPublicStatus() {
		return publicStatus;
	}

	public void setPublicStatus(boolean publicStatus) {
		this.publicStatus = publicStatus;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalParticipants() {
		return totalParticipants;
	}

	public void setTotalParticipants(int totalParticipants) {
		this.totalParticipants = totalParticipants;
	}

	@Override
	public String toString() {
		return "Goal [id=" + id + ", title=" + title + ", explanation=" + explanation + ", mainImage=" + mainImage
				+ ", goodEx=" + goodEx + ", badEx=" + badEx + ", endDate=" + endDate + ", startDate=" + startDate
				+ ", publicStatus=" + publicStatus + ", regdate=" + regdate + ", count=" + count + ", userId=" + userId
				+ ", totalParticipants=" + totalParticipants + "]";
	}
    
}
