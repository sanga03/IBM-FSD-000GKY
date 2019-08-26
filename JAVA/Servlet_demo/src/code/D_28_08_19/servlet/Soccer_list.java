package code.D_28_08_19.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
//		EmployeeServiceImplementation es = new EmployeeServiceImplementation();

		List<Employee> l = new ArrayList<Employee>();
		l.add(new Employee(1, "das", "vikram", 12331));
		l.add(new Employee(2, "das", "vikram", 12331));
		l.add(new Employee(3, "das", "vikram", 12331));
		l.add(new Employee(4, "das", "vikram", 12331));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<table>");
		for (Employee ll : l) {
			out.println("<tr><td>" + ll.getFirstName() + "</td><td>" + ll.getLastName() + "</td><td>" + ll.getSalary()
					+ "</tr>");
		}

		out.println("</table><b>hey all</b>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
