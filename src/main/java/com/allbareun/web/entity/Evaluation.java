package com.allbareun.web.entity;

import java.util.Date;
import java.util.List;

public class Evaluation {

	private int answer1;
	private int answer2;
	private int answer3;
	private int goalId;
	private int id;
	private int userId;
	private Date regDate;
	private int certificationId;
	
	
	public Evaluation() {
		// TODO Auto-generated constructor stub
	}


	public Evaluation(int answer1, int answer2, int answer3, int goalId, int id, int userId, Date regDate,
			int certificationId) {
		super();
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.goalId = goalId;
		this.id = id;
		this.userId = userId;
		this.regDate = regDate;
		this.certificationId = certificationId;
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


	public int getGoalId() {
		return goalId;
	}


	public void setGoalId(int goalId) {
		this.goalId = goalId;
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


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getCertificationId() {
		return certificationId;
	}


	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}


	@Override
	public String toString() {
		return "Evaluation [answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", goalId=" + goalId
				+ ", id=" + id + ", userId=" + userId + ", regDate=" + regDate + ", certificationId=" + certificationId
				+ "]";
	}





	
	
	
	
	
}
