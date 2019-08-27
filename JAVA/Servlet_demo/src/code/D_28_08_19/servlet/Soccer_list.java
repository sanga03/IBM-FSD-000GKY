package code.D_28_08_19.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.D_27_08_19.Connection.ConnectionFactory;

//import code.D_20_08.EmployeSql.model.Employee;
//import code.D_20_08.EmployeSql.services.EmployeeServiceImplementation;

/**
 * Servlet implementation class Soccer_list
 */
@WebServlet("/soccer_list.view")
public class Soccer_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		format_xml(request, response);
	}

	private void format_xml(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Connection conn = ConnectionFactory.getConnection();
		Statement st;
		try {
			PrintWriter pwt = response.getWriter();
			st = (Statement) conn.createStatement();
			ResultSet rset = st.executeQuery("select title,season,year from league");
			pwt.println("<table>");
			while(rset.next()) {
				pwt.println("<tr><td>"+rset.getString(1)+"</td>"+"<td>"+rset.getString(2)+"</td>"+"<td>"+rset.getString(3)+"</td></tr>");
			}
			pwt.println("</table>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
