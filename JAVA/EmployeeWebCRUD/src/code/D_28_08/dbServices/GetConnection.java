package code.D_28_08.dbServices;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GetConnection {

	private static DataSource dataSource;
	private static Connection connection=null;
	private GetConnection() {
				
	}
	
	
	public static Connection getConnection() {
		
		Context context;
		try {
			context = new InitialContext();
			Object o = context.lookup("java:/comp/env/jdbc/mysql");
			dataSource = (DataSource)o;
			connection = dataSource.getConnection();
			return connection;
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
}
