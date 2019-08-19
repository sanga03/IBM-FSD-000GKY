package code.D_14_08.jdbc;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class jdbc_demo {
public static void main(String[] args) throws SQLException {
//	Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/xibm?useSSL=false","root","mysql");
//	System.out.println(conn);
//	Statement st = (Statement) conn.createStatement();
//	ResultSet resultset = st.executeQuery("select * from eibm");
//	while(resultset.next()) {
//		System.out.println(resultset.getObject(1));
//	}	
	
	JdbcSingelton jdbcSingelton = JdbcSingelton.getJdbcSingelton();
	Connection conn = (Connection) jdbcSingelton.getConnection();
	PreparedStatement pst = (PreparedStatement) conn.prepareStatement("insert into eibm values(?,?,?)");
	pst.setInt(1, 12);
	pst.setString(2, "sangamesh");
	pst.setString(3, "sangu4403!asd.com");
	int count = pst.executeUpdate();
	System.out.println(count+"rows updated");
}
}
