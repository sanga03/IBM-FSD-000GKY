package code.D_14_08.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSingelton {
	private static Connection conn = null;
	private static JdbcSingelton jdbcSingelton =null;
	private static final String url="jdbc:mysql://localhost:3306/xibm?useSSL=false";
	public static JdbcSingelton getJdbcSingelton() throws SQLException {
		if(jdbcSingelton == null) {
			jdbcSingelton = new JdbcSingelton();
		}
		return jdbcSingelton;
	}

	private JdbcSingelton() throws SQLException {
		conn = DriverManager.getConnection(url,"root","mysql");
	}
	public Connection getConnection() throws SQLException {
	
	return conn;
	}
	
}
