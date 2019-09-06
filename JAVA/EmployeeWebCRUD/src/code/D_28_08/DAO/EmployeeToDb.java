package code.D_28_08.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import code.D_28_08.Model.Employee;
import code.D_28_08.dbServices.GetConnection;

public class EmployeeToDb {

	private Connection connection;

	public int addEmployee(Employee emp) {
		connection = GetConnection.getConnection();
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("insert into employee(name,password,email,country) values(?,?,?,?)");
			pst.setString(1, emp.getName());
			pst.setString(2, emp.getPassword());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getCountry());
			int val = pst.executeUpdate();
			return val;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteEmployee(int id) {
		try {
			PreparedStatement pst;
			Connection connection = GetConnection.getConnection();
			pst = connection.prepareStatement("delete from employee where id=?");
			pst.setInt(1, id);
			int val = pst.executeUpdate();
			return val;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public int updateEmployee(int id, Employee emp) {
System.out.println("update+"+id);
		try {
			PreparedStatement pst;
			Connection connection = GetConnection.getConnection();
			pst = connection.prepareStatement("update  employee set name=?, password=?, email=?, country=? where id=?");
			pst.setString(1, emp.getName());
			pst.setString(2, emp.getPassword());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getCountry());
			pst.setInt(5, id);
			int val = pst.executeUpdate();
			return val;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public int getId(Employee emp) {

		try {
			PreparedStatement pst;
			Connection connection = GetConnection.getConnection();
			pst = connection.prepareStatement(
					"select  id,name from  employee where name=? AND password=? AND email=? AND country=?");
			pst.setString(1, emp.getName());
			pst.setString(2, emp.getPassword());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getCountry());
			ResultSet rset = pst.executeQuery();
			while (rset.next()) {
				return rset.getInt(1);
			}
			int id = rset.getInt(1);
			System.out.println("---id");
			System.out.println(id);
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> emplist = new ArrayList<Employee>();
		try {
			Statement st;
			Connection connection = GetConnection.getConnection();
			ResultSet rset;
			st = connection.createStatement();
			rset = st.executeQuery("select name,password,email,country from employee");

			while (rset.next()) {
				emplist.add(new Employee(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}

			return emplist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emplist;
	}
	
	
	public boolean checkUser(String name,String password) {
		
		boolean flag = false;
		
		try {
			Connection conn = GetConnection.getConnection();
			PreparedStatement st;
			st = connection.prepareStatement("select * from employee where name=? password=?");
			st.setString(1, name);
			st.setString(2, password);
			ResultSet rset = st.executeQuery();
			while(rset.next()) {
				if(rset.getString(2)!="") {
					flag=true;
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public Employee getEmployee(int id) {

		Employee emp = null;
		try {
			PreparedStatement st;
			Connection connection = GetConnection.getConnection();
			ResultSet rset;
			st = connection.prepareStatement("select name,password,email,country from employee where id=?");
			st.setInt(1, id);
			rset = st.executeQuery();
			while (rset.next()) {
			System.out.println(rset.getString(1));
				emp=new Employee(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
				return emp;
				
			}

			return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

}
