package code.D_28_08.Controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.D_28_08.DAO.EmployeeToDb;
import code.D_28_08.Model.Employee;;

@WebServlet("/view.list")
public class ViewList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doProcess(request,response);
	}

	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.println("<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Insert title here</title>\r\n" + 
					"\r\n" + 
					"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n" + 
					"<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n" + 
					"</head><body>");
			
			pw.println("<table class=\"table table-bordered\">");
		List<Employee> empList=new EmployeeToDb().getAllEmployee();
		pw.println("<thead> <th>Name</th> <th>Email</th> <th>Country</th> <th>Update</th> <th>Delete</th></thead>");
		for(Employee emp :empList) {
			
			int id=new EmployeeToDb().getId(emp);
			pw.println("<tr><td>"+emp.getName()+"</td><td>"+emp.getEmail()+"</td><td>"+emp.getCountry()+"</td><td><a href=doUpdates?id="+id+">Update</a></td><td><a href=doDelete?id="+id+">Delete</a></td>");
		}
		pw.println("</table");	
		pw.println("</body>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doProcess(request, response);
}

}
