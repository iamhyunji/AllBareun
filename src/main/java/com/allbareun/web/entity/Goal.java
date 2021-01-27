package com.allbareun.web.entity;

import java.util.Date;

public class Goal {
	private int id;
	private String userId;
	private String title;
	private String explanation;
	private String mainImage;
	private String goodEx;
	private String badEx;
	private Date startDate;
	private Date endDate;
	private boolean publicStatus;
	private Date regDate;
	private int count;
	
	public Goal() {
		// TODO Auto-generated constructor stub
	}

	public Goal(int id, String userId, String title, String explanation, String mainImage, String goodEx, String badEx,
			Date startDate, Date endDate, boolean publicStatus, Date regDate, int count) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.explanation = explanation;
		this.mainImage = mainImage;
		this.goodEx = goodEx;
		this.badEx = badEx;
		this.startDate = startDate;
		this.endDate = endDate;
		this.publicStatus = publicStatus;
		this.regDate = regDate;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean getPublicStatus() {
		return publicStatus;
	}

	public void setPublicStatus(boolean publicStatus) {
		this.publicStatus = publicStatus;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Goal [id=" + id + ", userId=" + userId + ", title=" + title + ", explanation=" + explanation
				+ ", mainImage=" + mainImage + ", goodEx=" + goodEx + ", badEx=" + badEx + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", publicStatus=" + publicStatus + ", regDate=" + regDate + ", count="
				+ count + "]";
	}
	
	

	
	
}
