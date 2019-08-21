package code.D_21_08.swing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import code.D_20_08.EmployeSql.Connect.ConnectionClass;

public class Rs2xmlConfig {
private ConnectionClass cl ;
private Connection conn;
public Rs2xmlConfig() throws SQLException {
	cl = ConnectionClass.createConnection();
	conn = cl.getConnection();
}
public ResultSet getRset() throws SQLException {
	Statement st= conn.createStatement();
	ResultSet rset =st.executeQuery("select id as 'ID' ,fname as 'First Name' ,lname as 'Last Name', salary as 'Salary' from emp");
	return rset;
}

public ResultSet getRsetCart() throws SQLException {
	Statement st= conn.createStatement();
	ResultSet rset =st.executeQuery("select id as 'ID' ,fname as 'First Name' ,lname as 'Last Name', salary as 'Salary', location as 'Location', numberemp as 'Number of Employees' from emp,Dept");
	return rset;
}

}
