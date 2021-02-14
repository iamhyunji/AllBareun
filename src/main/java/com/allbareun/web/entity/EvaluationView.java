package com.allbareun.web.entity;

import java.util.Date;

public class EvaluationView extends Evaluation{
	
	private int month;
	private int lineSum;
	private String categoryTitle;
	private int categoryId;
	private int categorySum;
	private String profile;
	private int barSum;
	
	
	public EvaluationView() {
		
	}

	public EvaluationView(int answer1, int answer2, int answer3, int goalId, int id, int userId, Date regDate,
			int certificationId, int month, int lineSum, String categoryTitle,int categoryId, int categorySum,String profile,int barSum) {
		super(answer1, answer2, answer3, goalId, id, userId, regDate, certificationId);
		this.month = month;
		this.lineSum = lineSum;
		this.categoryTitle = categoryTitle;
		this.categoryId = categoryId;
		this.categorySum = categorySum;
		this.profile = profile;
		this.barSum = barSum;
		
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}



	public int getLineSum() {
		return lineSum;
	}

	public void setLineSum(int lineSum) {
		this.lineSum = lineSum;
	}
	
	
	
	

	public int getBarSum() {
		return barSum;
	}

	public void setBarSum(int barSum) {
		this.barSum = barSum;
	}

	public int getCategorySum() {
		return categorySum;
	}

	public void setCategorySum(int categorySum) {
		this.categorySum = categorySum;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "EvaluationView [month=" + month + ", lineSum=" + lineSum + ", barSum=" + barSum + ",categoryTitle=" + categoryTitle
				+ ", categoryId=" + categoryId + ", categorySum=" + categorySum + ", getAnswer1()=" + getAnswer1()
				+ ", getAnswer2()=" + getAnswer2() + ", getAnswer3()=" + getAnswer3() + ", getGoalId()=" + getGoalId()
				+ ", getId()=" + getId() + ", getUserId()=" + getUserId() + ", getRegDate()=" + getRegDate()
				+ ", getCertificationId()=" + getCertificationId() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}



}
