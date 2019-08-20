package code.D_20_08.EmployeSql.services;

import java.util.List;

import code.D_20_08.EmployeSql.dao.EmployeeDoaImplementation;
import code.D_20_08.EmployeSql.model.Employee;

public class EmployeeServiceImplementation implements EmployeeServiceInterface {

	private EmployeeDoaImplementation empD = null;

	public EmployeeServiceImplementation() {
		empD = new EmployeeDoaImplementation();
	}

	@Override
	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empD.createEmployee(emp);
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return empD.getEmployee();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return empD.getEmployeeById(id);
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empD.updateEmployee(emp);
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return empD.deleteEmployee(id);
	}

}
