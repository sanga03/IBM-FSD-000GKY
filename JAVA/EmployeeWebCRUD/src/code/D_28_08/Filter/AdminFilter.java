package code.D_28_08.Filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import code.D_28_08.DAO.EmployeeToDb;
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
		User user = new User(name, password);
		
		request.setAttribute("user", user);
		System.out.println(name+password);
		
		User user1= (User)request.getAttribute("user");
		System.out.println(user1);
		boolean flag=new EmployeeToDb().checkUser(user1.getName(),user1.getPassword());
		if(flag) {
			chain.doFilter(request, response);
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("err.html");
			requestDispatcher.forward(request, response);
		}



		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
