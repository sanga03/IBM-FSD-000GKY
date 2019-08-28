package code.D_28_08.View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.D_28_08.DAO.EmployeeToDb;
import code.D_28_08.Model.Employee;

/**
 * Servlet implementation class doUpdate
 */
@WebServlet("/doUpdates")
public class doUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		int id =  Integer.parseInt(request.getParameter("id"));
		Employee emp = new EmployeeToDb().getEmployee(id);
		System.out.println(emp.getName());
		
		PrintWriter pwt = response.getWriter();
		pwt.println("\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>update</title>\r\n" + 
				"\r\n" + 
				"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n" + 
				"<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"row\">\r\n" + 
				"<div class=\"col\">\r\n" + 
				"<h2>update Employee data</h2>\r\n" + 
				"\r\n" + 
				"<form action=\"updateEmployee\" >\r\n" + 
				"\r\n" + 
				"<div class=\"input-group mb-3\">\r\n" + 
				"  <div class=\"input-group-prepend\">\r\n" + 
				"    <span class=\"input-group-text\" id=\"inputGroup-sizing-default\">Name:</span>\r\n" + 
				"  </div>\r\n" + 
				"  <input type=\"text\" class=\"form-control\" value='"+emp.getName()+"' name='name' aria-label=\"Sizing example input\" aria-describedby=\"inputGroup-sizing-default\">\r\n" + 
						
" id: <input type=\"hidden\" class=\"form-control\" value='"+id+"' name='id' aria-label=\"Sizing example input\" aria-describedby=\"inputGroup-sizing-default\">\r\n" + 

				"  \r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"input-group mb-3\">\r\n" + 
				"  <div class=\"input-group-prepend\">\r\n" + 
				"    <span class=\"input-group-text\" id=\"inputGroup-sizing-default\">password:</span>\r\n" + 
				"  </div>\r\n" + 
				"  <input type=\"password\" class=\"form-control\" value='"+emp.getPassword() +"'name=\"password\" aria-label=\"Sizing example input\" aria-describedby=\"inputGroup-sizing-default\">\r\n" + 
				"  \r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"input-group mb-3\">\r\n" + 
				"  <div class=\"input-group-prepend\">\r\n" + 
				"    <span class=\"input-group-text\" id=\"inputGroup-sizing-default\">email:</span>\r\n" + 
				"  </div>\r\n" + 
				"  <input type=\"email\" class=\"form-control\" name=\"email\"value="+emp.getEmail() +" aria-label=\"Sizing example input\" aria-describedby=\"inputGroup-sizing-default\">\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div class=\"input-group mb-3\">\r\n" + 
				"  <div class=\"input-group-prepend\">\r\n" + 
				"    <span class=\"input-group-text\" id=\"inputGroup-sizing-default\">Country:</span>\r\n" + 
				"  </div>\r\n" + 
				"  <select class=\"form-control\"name=\"country\">\r\n" + 
				"  <option value=\"un\"></option>\r\n" + 
				"  <option value=\"INDIA\">INDIA</option>\r\n" + 
				"  <option value=\"NEPAL\">NEPAL</option>\r\n" + 
				"  <option value=\"AUS\">AUSTRALIA</option>\r\n" + 
				"  <option value=\"USA\">USA</option>\r\n" + 
				"  </select>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<input type=\"submit\" class=\"btn primary\" value=\"update employee\">\r\n" + 
				"</form>\r\n" + "</body>"+
				"");
		
	}

}
