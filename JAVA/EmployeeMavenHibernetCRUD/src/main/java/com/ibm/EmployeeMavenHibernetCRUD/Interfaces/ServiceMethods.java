package com.ibm.EmployeeMavenHibernetCRUD.Interfaces;

import java.util.List;

import com.ibm.EmployeeMavenHibernetCRUD.model.EmployeeModel;

public interface ServiceMethods {

public void addEmployee(EmployeeModel empd);
public EmployeeModel getEmployee(int id);
public List<EmployeeModel> getEmployees();
public void updateEmployee(EmployeeModel empd);
public void deleteEmployee(EmployeeModel empd);
}

