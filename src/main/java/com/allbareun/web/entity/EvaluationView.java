package com.allbareun.web.entity;

import java.util.Date;

public class EvaluationView extends Evaluation{
	
	private int month;
	private int lineSum;
	private String categoryTitle;
	private int categoryId;
	private int categorySum;
	
	
	public EvaluationView() {
		
	}

	public EvaluationView(int answer1, int answer2, int answer3, int goalId, int id, int userId, Date regDate,
			int certificationId, int month, int lineSum, String categoryTitle,int categoryId, int categorySum) {
		super(answer1, answer2, answer3, goalId, id, userId, regDate, certificationId);
		this.month = month;
		this.lineSum = lineSum;
		this.categoryTitle = categoryTitle;
		this.categoryId = categoryId;
		this.categorySum = categorySum;
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

	@Override
	public String toString() {
		return "EvaluationView [month=" + month + ", lineSum=" + lineSum + ", categoryTitle=" + categoryTitle
				+ ", categoryId=" + categoryId + ", categorySum=" + categorySum + ", getAnswer1()=" + getAnswer1()
				+ ", getAnswer2()=" + getAnswer2() + ", getAnswer3()=" + getAnswer3() + ", getGoalId()=" + getGoalId()
				+ ", getId()=" + getId() + ", getUserId()=" + getUserId() + ", getRegDate()=" + getRegDate()
				+ ", getCertificationId()=" + getCertificationId() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}



}
