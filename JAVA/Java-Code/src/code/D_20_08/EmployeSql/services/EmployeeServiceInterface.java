package code.D_20_08.EmployeSql.services;

import java.util.List;

import code.D_20_08.EmployeSql.model.Employee;

public interface EmployeeServiceInterface {

	public void createEmployee(Employee emp);
	public List<Employee> getEmployee();
	public Employee getEmployeeById(int id);
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(int id);
}
