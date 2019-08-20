package code.D_20_08.EmployeSql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import code.D_20_08.EmployeSql.Connect.ConnectionClass;
import code.D_20_08.EmployeSql.model.Employee;

public class EmployeeDoaImplementation implements EmployeeDao {

	private Connection conn;
	private ConnectionClass conobj;
	private ResultSet resultSet;
	private PreparedStatement pst;
	private Statement st;
	private Employee emp;

	public EmployeeDoaImplementation() {

		try {
			conobj = ConnectionClass.createConnection();
			conn = conobj.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createEmployee(Employee emp) {
		try {
			pst = conn.prepareStatement("insert into emp values(?,?,?,?)");
			pst.setInt(1, emp.getId());
			pst.setString(2, emp.getFirstName());
			pst.setString(3, emp.getLastName());
			pst.setInt(4, emp.getSalary());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> getEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			st = conn.createStatement();
			resultSet = st.executeQuery("select * from emp");
			while (resultSet.next()) {
				list.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;

	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		try {
			pst = conn.prepareStatement("select * from emp where id=?");
			pst.setInt(1, id);
			resultSet = pst.executeQuery();
			while(resultSet.next()) {
				emp = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4));
			}
			return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (new Employee());
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		try {
			pst = conn.prepareStatement("update emp  set fname=? ,lname=?, salary=? where id=?");
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setInt(3, emp.getSalary());
			pst.setInt(4, emp.getId());
			int r = pst.executeUpdate();
			if (r > 0) {
				return true;
			} else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		try {
			pst = conn.prepareStatement("delete from emp where id=?");
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			if (r > 0) {
				return true;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
