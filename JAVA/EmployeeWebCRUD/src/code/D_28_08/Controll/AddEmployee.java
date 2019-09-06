package code.D_28_08.Controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.D_28_08.DAO.EmployeeToDb;
import code.D_28_08.Model.Employee;

@WebServlet("/addEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request,response);
	
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
	response.setContentType("text/html");
	PrintWriter pw= response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		pw.println(name);
		Employee emp  = new Employee(name, password, email, country);
		EmployeeToDb edb = new EmployeeToDb();
		int resp = edb.addEmployee(emp);
		if(resp>0) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
			try {
				requestDispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("err.html");
			try {
				requestDispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request,response);
	}

}
