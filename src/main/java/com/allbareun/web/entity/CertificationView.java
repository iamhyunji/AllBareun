package com.allbareun.web.entity;

import java.util.Date;

public class CertificationView extends Certification{
	
	private String profile;
	private String name;

	
	public CertificationView() {
		// TODO Auto-generated constructor stub
	}
	
	public CertificationView(int goalId, int id, String authImage, Date regdate, int userId, String profile,
			String name) {
		super(goalId, id, authImage, regdate, userId);
		this.profile = profile;
		this.name = name;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	

	
}
