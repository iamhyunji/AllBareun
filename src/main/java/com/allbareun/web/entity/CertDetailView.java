package com.allbareun.web.entity;

import java.util.Date;

public class CertDetailView {
	
	private int id;
	private int userId;
	private int goalId;
	private Date regdate;
	private String authImage;
	private String name;
	private String profile;
	private int answer1;
	private int answer2;
	private int answer3;
	private String explanation;
	
	public CertDetailView() {
		// TODO Auto-generated constructor stub
	}

	public CertDetailView(int id, int userId, int goalId, Date regdate, String authImage, String name, String profile,
			int answer1, int answer2, int answer3, String explanation) {
		super();
		this.id = id;
		this.userId = userId;
		this.goalId = goalId;
		this.regdate = regdate;
		this.authImage = authImage;
		this.name = name;
		this.profile = profile;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.explanation = explanation;
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

	public int getGoalId() {
		return goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getAuthImage() {
		return authImage;
	}

	public void setAuthImage(String authImage) {
		this.authImage = authImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getAnswer1() {
		return answer1;
	}

	public void setAnswer1(int answer1) {
		this.answer1 = answer1;
	}

	public int getAnswer2() {
		return answer2;
	}

	public void setAnswer2(int answer2) {
		this.answer2 = answer2;
	}

	public int getAnswer3() {
		return answer3;
	}

	public void setAnswer3(int answer3) {
		this.answer3 = answer3;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	@Override
	public String toString() {
		return "CertDetailView [id=" + id + ", userId=" + userId + ", goalId=" + goalId + ", regdate=" + regdate
				+ ", authImage=" + authImage + ", name=" + name + ", profile=" + profile + ", answer1=" + answer1
				+ ", answer2=" + answer2 + ", answer3=" + answer3 + ", explanation=" + explanation + "]";
	}
	
	
}
