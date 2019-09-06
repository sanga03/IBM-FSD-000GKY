package com.ibm.EmployeeMavenHibernetCRUD.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class EmployeeModel {

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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
@Id
@Column(name="id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name="name")
private String name;
@Column(name="email")

private String email;
@Column(name="password")
private String password;
@Column(name="country")
private String country;
public EmployeeModel(String name, String email, String password, String country) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.country = country;
}
public EmployeeModel() {
	super();
}
@Override
public String toString() {
	return "EmployeeModel [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", country="
			+ country + "]";
}




}
