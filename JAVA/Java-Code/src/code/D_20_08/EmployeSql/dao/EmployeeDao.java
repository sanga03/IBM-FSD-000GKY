package code.D_20_08.EmployeSql.dao;

import java.util.List;

import code.D_20_08.EmployeSql.model.Employee;

public interface EmployeeDao {

	public void createEmployee(Employee emp);
	public List<Employee> getEmployee();
	public Employee getEmployeeById(int id);
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(int id);
}
