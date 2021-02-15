package com.allbareun.web.entity;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private Date joinDate;
	private String profile;
	private String birth;
	private String phone;
	private String mail;
	
	// --------------------------------- Constructor ---------------------------------
	public User() {
		this(0, null, null, null, null, null, null, null, null,null);
	}

	public User(int id, String name, String email, String password, String gender, Date joinDate, String profile,
			String birth, String phone, String mail) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.joinDate = joinDate;
		this.profile = profile;
		this.birth = birth;
		this.phone = phone;
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	// --------------------------------- Getters/Setters ---------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	// --------------------------------- Function ---------------------------------

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", joinDate=" + joinDate + ", profile=" + profile + ", birth=" + birth + ", phone=" + phone
				+ ", mail=" + mail + "]";
	}
	
	
}
