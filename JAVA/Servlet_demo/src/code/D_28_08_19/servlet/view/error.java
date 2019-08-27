package code.D_28_08_19.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class error
 */
@WebServlet("/error.view")
public class error extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		List<String> err = (List<String>) request.getAttribute("err");
		response.setContentType("text/html");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			for(String e: err ) { 
				pw.println(e);
				pw.println("<br>");
			}
		
			pw.println("<br><input type='button' value='go back'/>");
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	
	}

}
