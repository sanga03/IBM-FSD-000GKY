package code.D_27_08_19.Connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class ConnectionFactory {

	private static DataSource dataSource;
	private static Connection connection;
;
	
	public static Connection getConnection() {
		
		try {
			Context context = new InitialContext();
			Object o = context.lookup("java:/comp/env/jdbc/mysql");
			dataSource = (DataSource)o;
			connection = dataSource.getConnection();
			
		return connection;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
