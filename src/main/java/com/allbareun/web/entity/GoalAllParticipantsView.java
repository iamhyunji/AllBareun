package com.allbareun.web.entity;

public class GoalAllParticipantsView {
	private int goalId;
    private int userId;
    private String userName;
    private String userProfile;
    
    // --------------------------------- Constructor ---------------------------------
    public GoalAllParticipantsView() {
    	this(0, 0, null, null);
	}

	public GoalAllParticipantsView(int goalId, int userId, String userName, String userProfile) {
		this.goalId = goalId;
		this.userId = userId;
		this.userName = userName;
		this.userProfile = userProfile;
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

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	
	// --------------------------------- Function ---------------------------------
	@Override
	public String toString() {
		return "GoalAllParticipantsView [goalId=" + goalId + ", userId=" + userId + ", userName=" + userName
				+ ", userProfile=" + userProfile + "]";
	}
    
}
