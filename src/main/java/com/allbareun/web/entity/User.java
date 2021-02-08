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
	private String age;
	private String phone;
	
	// --------------------------------- Constructor ---------------------------------
	public User() {
		this(0, null, null, null, null, null, null, null, null);
	}

	public User(int id, String name, String email, String password, String gender, Date joinDate, String profile,
			String age, String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.joinDate = joinDate;
		this.profile = profile;
		this.age = age;
		this.phone = phone;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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
				+ gender + ", joinDate=" + joinDate + ", profile=" + profile + ", age=" + age + ", phone=" + phone
				+ "]";
	}

	
	
}
