package com.example.demo.Model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CreateUserResponseModel {
	private String userId;
	private String fname;
	private String lname;
	private String email;

	public CreateUserResponseModel() {
		super();
	}

	public CreateUserResponseModel(String userId, String fname, String lname, String email) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
