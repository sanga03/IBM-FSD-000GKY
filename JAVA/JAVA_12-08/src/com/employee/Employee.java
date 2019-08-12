package com.employee;

public class Employee {
	String name;
	String dept;
	String location;
	public Employee(String name, String dept, String location) {
		super();
		this.name = name;
		this.dept = dept;
		this.location = location;
	}
	public Employee() {
		super();
	}

	protected String getDetails() {
		return "Name:"+name+" Dept:"+dept+" Location:"+location;
	}
}
