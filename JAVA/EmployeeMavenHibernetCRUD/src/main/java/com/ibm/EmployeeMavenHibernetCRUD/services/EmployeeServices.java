package com.ibm.EmployeeMavenHibernetCRUD.services;

import java.util.List;

import com.ibm.EmployeeMavenHibernetCRUD.Interfaces.ServiceMethods;
import com.ibm.EmployeeMavenHibernetCRUD.doa.EmployeeDoa;
import com.ibm.EmployeeMavenHibernetCRUD.model.EmployeeModel;

public class EmployeeServices implements ServiceMethods {

	private EmployeeDoa emp;
	public EmployeeServices() {
		emp = new EmployeeDoa();
	}
	@Override
	public void addEmployee(EmployeeModel empd) {
		emp.addEmployee(empd);
	}

	@Override
	public EmployeeModel getEmployee(int id) {
		// TODO Auto-generated method stub
		return emp.getEmployee(id);
	}

	@Override
	public List<EmployeeModel> getEmployees() {
		// TODO Auto-generated method stub
		return emp.getEmployees();
	}

	@Override
	public void updateEmployee(EmployeeModel empd) {
		// TODO Auto-generated method stub
		emp.updateEmployee(empd);
	}

	@Override
	public void deleteEmployee(EmployeeModel empd) {
		// TODO Auto-generated method stub
	
		emp.deleteEmployee(empd);
	}

}
