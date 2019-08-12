package com.employee;

public class PermanentEmployee extends Employee {
	int salary;

	public PermanentEmployee(String name, String dept, String location,int salary) {
		super(name, dept, location);
		this.salary=salary;
		// TODO Auto-generated constructor stub
	}

	public PermanentEmployee() {
		// TODO Auto-generated constructor stub
	}
	public PermanentEmployee(int sal) {
		// TODO Auto-generated constructor stub
		this.salary=sal;
	}
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails()+" Salary"+salary;
	}
	

}
