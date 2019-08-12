package com.employee;

public class TempEmployee extends Employee {
double rate_per_hr;
	public TempEmployee(String name, String dept, String location,double rph) {
		super(name, dept, location);
		this.rate_per_hr=rph;
		// TODO Auto-generated constructor stub
	}

	public TempEmployee() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getDetails() {
		return super.getDetails()+" Rate Per Hour:"+rate_per_hr;
	}
	

}
