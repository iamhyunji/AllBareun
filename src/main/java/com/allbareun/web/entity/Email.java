package com.allbareun.web.entity;


public class Email {
	private String address;
	private String title;
	private String message;
	
	
	
	public Email(String address, String title, String message) {
		super();
		this.address = address;
		this.title = title;
		this.message = message;
	}
	
	public Email() {
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Email [address=" + address + ", title=" + title + ", message=" + message + "]";
	}	
	
	
}
