package com.employee;

public class Main_Emp {

	public static void main(String[] args) {
		Employee emp = null;
		emp=new Employee("sangamesh","FSD","Bangalore");
		System.out.println(emp.getDetails());
		emp=new PermanentEmployee("sangamesh","FSD","Bangalore",30000);
		System.out.println(emp.getDetails());
		emp = new TempEmployee("sangamesh","FSD","Bangalore",30.7);
		System.out.println(emp.getDetails());
	}

}
