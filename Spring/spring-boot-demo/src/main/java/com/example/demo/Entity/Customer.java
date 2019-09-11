package com.example.demo.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "crm")
public class Customer {
@Id

@Column(name="id")
private int id;

@Column(name="fname")
private String fname;
@Column(name="lname")
private String lname;
@Column(name="email")
private String email;
public Customer(String fname, String lname, String email) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.email = email;
}
public Customer() {
	// TODO Auto-generated constructor stub
}

public Customer(int id, String fname, String lname, String email) {
	this.id=id;
	this.fname = fname;
	this.lname = lname;
	this.email = email;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
@Override
public String toString() {
	return "Customer [fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
}
}
