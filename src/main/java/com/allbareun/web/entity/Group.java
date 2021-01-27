package com.allbareun.web.entity;

import java.util.Date;

public class Group {
	private int id;
	private int goalId;
	private int requestReceiveUserId;
	private int requestDispatchUserId;
	private Date requestDate;
    private boolean answer;
    private Date answerDate;
    
    // --------------------------------- Constructor ---------------------------------
    public Group() {
    	this(0, 0, 0, 0, null, false, null);
	}

	public Group(int id, int goalId, int requestReceiveUserId, int requestDispatchUserId, Date requestDate,
			boolean answer, Date answerDate) {
		this.id = id;
		this.goalId = goalId;
		this.requestReceiveUserId = requestReceiveUserId;
		this.requestDispatchUserId = requestDispatchUserId;
		this.requestDate = requestDate;
		this.answer = answer;
		this.answerDate = answerDate;
	}

	// --------------------------------- Getters/Setters ---------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoalId() {
		return goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	public int getRequestReceiveUserId() {
		return requestReceiveUserId;
	}

	public void setRequestReceiveUserId(int requestReceiveUserId) {
		this.requestReceiveUserId = requestReceiveUserId;
	}

	public int getRequestDispatchUserId() {
		return requestDispatchUserId;
	}

	public void setRequestDispatchUserId(int requestDispatchUserId) {
		this.requestDispatchUserId = requestDispatchUserId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	// --------------------------------- Function ---------------------------------
	@Override
	public String toString() {
		return "Group [id=" + id + ", goalId=" + goalId + ", requestReceiveUserId=" + requestReceiveUserId
				+ ", requestDispatchUserId=" + requestDispatchUserId + ", requestDate=" + requestDate + ", answer="
				+ answer + ", answerDate=" + answerDate + "]";
	}
    
}
