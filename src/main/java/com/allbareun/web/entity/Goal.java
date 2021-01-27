package com.allbareun.web.entity;

import java.util.Date;

public class Goal {
	private int id;
	private String title;
	private String explanation;
	private String mainImage;
	private String goodImage;
	private String badImage;
	private Date startDate;
	private Date endDate;
	private int pub;
	private Date regDate;
	private int count;
	public Goal(int id, String title, String explanation, String mainImage, String goodImage, String badImage,
			Date startDate, Date endDate, int pub, Date regDate, int count) {
		super();
		this.id = id;
		this.title = title;
		this.explanation = explanation;
		this.mainImage = mainImage;
		this.goodImage = goodImage;
		this.badImage = badImage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pub = pub;
		this.regDate = regDate;
		this.count = count;
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
	public String getGoodImage() {
		return goodImage;
	}
	public void setGoodImage(String goodImage) {
		this.goodImage = goodImage;
	}
	public String getBadImage() {
		return badImage;
	}
	public void setBadImage(String badImage) {
		this.badImage = badImage;
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
	public int getPub() {
		return pub;
	}
	public void setPub(int pub) {
		this.pub = pub;
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
		return "Goal [id=" + id + ", title=" + title + ", explanation=" + explanation + ", mainImage=" + mainImage
				+ ", goodImage=" + goodImage + ", badImage=" + badImage + ", startDate=" + startDate + ", endDate="
				+ endDate + ", pub=" + pub + ", regDate=" + regDate + ", count=" + count + "]";
	}
	
	
}
