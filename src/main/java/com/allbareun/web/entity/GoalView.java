package com.allbareun.web.entity;

import java.util.Date;

public class GoalView {
	private int id;
	private String title;
	private String mainImage;
	private Date endDate;
	private Date startDate;
	private int dateDiff;  // 총 기간
	private boolean publicStatus;
	private Date regdate;
	private int count;  // 1주에 인증횟수
	private String userName;
	private String categories;
	private String days;
	private int totalParticipants;
	private int nowParticipantsCount;
	private String categoriesColor;
	
	
	public GoalView() {
		// TODO Auto-generated constructor stub
	}


	public GoalView(int id, String title, String mainImage, Date endDate, Date startDate, int dateDiff,
			boolean publicStatus, Date regdate, int count, String userName, String categories, String days,
			int totalParticipants, int nowParticipantsCount, String categoriesColor) {
		super();
		this.id = id;
		this.title = title;
		this.mainImage = mainImage;
		this.endDate = endDate;
		this.startDate = startDate;
		this.dateDiff = dateDiff;
		this.publicStatus = publicStatus;
		this.regdate = regdate;
		this.count = count;
		this.userName = userName;
		this.categories = categories;
		this.days = days;
		this.totalParticipants = totalParticipants;
		this.nowParticipantsCount = nowParticipantsCount;
		this.categoriesColor = categoriesColor;
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


	public String getMainImage() {
		return mainImage;
	}


	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
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


	public int getDateDiff() {
		return dateDiff;
	}


	public void setDateDiff(int dateDiff) {
		this.dateDiff = dateDiff;
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


	public int getTotalParticipants() {
		return totalParticipants;
	}


	public void setTotalParticipants(int totalParticipants) {
		this.totalParticipants = totalParticipants;
	}


	public int getNowParticipantsCount() {
		return nowParticipantsCount;
	}


	public void setNowParticipantsCount(int nowParticipantsCount) {
		this.nowParticipantsCount = nowParticipantsCount;
	}


	public String getCategoriesColor() {
		return categoriesColor;
	}


	public void setCategoriesColor(String categoriesColor) {
		this.categoriesColor = categoriesColor;
	}

	

	


	@Override
	public String toString() {
		return "GoalView [id=" + id + ", title=" + title + ", mainImage=" + mainImage + ", endDate=" + endDate
				+ ", startDate=" + startDate + ", dateDiff=" + dateDiff + ", publicStatus=" + publicStatus
				+ ", regdate=" + regdate + ", count=" + count + ", userName=" + userName + ", categories=" + categories
				+ ", days=" + days + ", totalParticipants=" + totalParticipants + ", nowParticipantsCount="
				+ nowParticipantsCount + ", categoriesColor=" + categoriesColor + "]";
	}



	
	
	
}
