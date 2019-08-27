package code.D_28_08_19.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormViewer
 */
@WebServlet(
		urlPatterns = { "/form.view" }, 
		initParams = { 
				@WebInitParam(name = "league-list", value = "Barclys EPL,Serea A,LaLiga,League A,Indian Super League")
		})
public class FormViewer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String lList[] = null;
   
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		String l = config.getInitParameter("league-list");
		lList=l.split(",");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		@SuppressWarnings("unchecked")
		List<String> err=(List<String>) request.getAttribute("err");
		if(err!=null)
		{
			for(String s:err)
			{
				pw.println("<font color='red'>"+s+"</font><br/>");
				
			}
		}
		
		
	
		pw.println("<form action='addPlayContoller'>\r\n" + 
				"<input type='text' name='season'>\r\n" + 
				"<input type='text' name='year'>\r\n" + 
				"<select name='league'>");
		for(String a :lList) {
			pw.println("<option value'"+a+"'/>"+a+"</option>");
		}
		pw.println("</select>");
		pw.println("\r\n" + 
				"<input type='submit' value='submit'>\r\n" + 
				"</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
