package code.hiber.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.hiber.doa.HiberDoa;
import code.hiber.model.CD;
import code.hiber.model.FeaturedEdition;
import code.hiber.model.specialCd;
import code.hiber.services.HiberServices;

public class createHiber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public createHiber() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	deProcess(request,response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	deProcess(request,response);
	}

	private void deProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
//		response.setContentType("text/html");
//		PrintWriter pw  = response.getWriter();
//		pw.println("asdada");
		String ctype= request.getParameter("ctype");
		String title= request.getParameter("title");
		String artist=request.getParameter("artist");
		String sdate =request.getParameter("rdate");
		System.out.println(sdate+ctype+title+artist);
		HiberServices hiberServices = new HiberServices();
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
			System.out.println(date1);
			CD cd = new CD(title,artist,date1);
			System.out.println(ctype);
					if(ctype.equals("cd")) {
						System.out.println("in ccd");
						hiberServices.createCd(cd);
					}else if(ctype.equals("sp")) {
						
						hiberServices.createCd(new specialCd(cd,request.getParameter("sptext")));
					}else {
						hiberServices.createCd(new FeaturedEdition(cd,request.getParameter("sptext"),Integer.parseInt(request.getParameter("yyear"))));
					}
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("list");
					requestDispatcher.include(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		;
	}

}
