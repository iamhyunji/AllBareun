package com.allbareun.web.entity;

public class GoalAchievementView {

	private int goalId;
    private int userId;
    private String userName;
    private int count;
    private int dateDiff;
    private int expected;
    private int evalCnt;
    private float achieve;
    
    // --------------------------------- Constructor ---------------------------------
    public GoalAchievementView() {
    	this(0, 0, null, 0, 0, 0, 0, 0f);
	}

	public GoalAchievementView(int goalId, int userId, String userName, int count, int dateDiff, int expected, int evalCnt, float achieve) {
		
		this.goalId = goalId;
		this.userId = userId;
		this.userName = userName;
		this.count = count;
		this.dateDiff = dateDiff;
		this.expected = expected;
		this.evalCnt = evalCnt;
		this.achieve = achieve;
	}

	// --------------------------------- Getters/Setters ---------------------------------
	public int getGoalId() {
		return goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getDateDiff() {
		return dateDiff;
	}

	public void setDateDiff(int dateDiff) {
		this.dateDiff = dateDiff;
	}

	public int getExpected() {
		return expected;
	}

	public void setExpected(int expected) {
		this.expected = expected;
	}

	public int getEvalCnt() {
		return evalCnt;
	}

	public void setEvalCnt(int evalCnt) {
		this.evalCnt = evalCnt;
	}

	public float getAchieve() {
		return achieve;
	}

	public void setAchieve(float achieve) {
		this.achieve = achieve;
	}

	// --------------------------------- Function ---------------------------------
	@Override
	public String toString() {
		return "GoalAchievementView [goalId=" + goalId + ", userId=" + userId + ", userName=" + userName + ", count="
				+ count + ", dateDiff=" + dateDiff + ", expected=" + expected + ", evalCnt=" + evalCnt + ", achieve="
				+ achieve + "]";
	}
    
}
