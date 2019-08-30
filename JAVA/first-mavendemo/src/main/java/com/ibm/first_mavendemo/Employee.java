package com.ibm.first_mavendemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="employee")
@Data
public class Employee {


@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", country="
				+ country + "]";
	}

@Id
@Column(name="id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "name")
private String name;
@Column(name = "password")
private String password;
@Column(name = "email")
private String email;
@Column(name = "country")
private String country;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Employee() {
		super();
	}

	public Employee(String name, String password, String email, String country) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.country = country;
	}

}
