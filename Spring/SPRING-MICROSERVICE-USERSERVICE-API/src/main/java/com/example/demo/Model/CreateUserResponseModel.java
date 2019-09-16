package com.example.demo.Model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CreateUserResponseModel {
	
	private String fname;
	private String lname;
	private String email;
	private String userid;
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public CreateUserResponseModel() {
		super();
	}

	public CreateUserResponseModel(String userid, String fname, String lname, String email) {
		super();
		this.userid=userid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
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
