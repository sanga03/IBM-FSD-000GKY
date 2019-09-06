package com.ibm.first_mavendemo.services;

import java.util.List;

import com.ibm.first_mavendemo.Employee;
import com.ibm.first_mavendemo.EmployeeDoa;

public class EmployeeService {
private EmployeeDoa employeeDoa;

	public EmployeeService() {
	super();
	employeeDoa=new EmployeeDoa();
}

	public void addEmployee(Employee emp) {
		employeeDoa.addEmployee(emp);
	}

public List<Employee> getEmployee(){
	return employeeDoa.getEmployee();
}


}
