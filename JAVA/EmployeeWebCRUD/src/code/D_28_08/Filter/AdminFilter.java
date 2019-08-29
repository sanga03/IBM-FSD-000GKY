package code.D_28_08.Filter;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.coyote.http11.Http11AprProtocol;

import code.D_28_08.DAO.EmployeeToDb;
import code.D_28_08.Model.Employee;
import code.D_28_08.Model.User;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST 
//				DispatcherType.FORWARD,
//				DispatcherType.INCLUDE, 
//				DispatcherType.ERROR
		},urlPatterns = {"/admin.varify"})
public class AdminFilter implements Filter {

	List<Employee> l = null;
    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
	
		String name =  request.getParameter("name");
		String password= request.getParameter("password");
		System.out.println("Name ----"+name+" "+password);
		boolean flag =false;
		for(Employee emp : l) {
			System.out.println(emp.getName()+emp.getPassword());
			if(name.toString().equals(emp.getName().toString()) && password.equals(emp.getPassword().toString())) {
				flag=true;
			}
		}
		
		if(flag) {
			chain.doFilter(request, response);
		}
		else {
			request.setAttribute("error","Invalid Credentials");
			request.setAttribute("name",name);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
		}



		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		Object o=fConfig.getServletContext().getAttribute("userList");
		@SuppressWarnings("unchecked")
		ArrayList<Employee> o2 = (ArrayList<Employee>)o;
		l=o2;
		
	}

}
