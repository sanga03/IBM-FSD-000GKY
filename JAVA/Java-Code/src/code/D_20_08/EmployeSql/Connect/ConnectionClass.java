package code.D_20_08.EmployeSql.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	private static Connection conn;
	private static ConnectionClass myconn;
	private static final String url="jdbc:mysql://localhost:3306/employee?useSSL=false";
	private ConnectionClass() throws SQLException {
		conn = DriverManager.getConnection(url,"root","mysql");
		
	}
	
	public static ConnectionClass createConnection() throws SQLException {
		if(myconn==null) {
			myconn =new ConnectionClass();
		}
	return myconn;	
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
}
