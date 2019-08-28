package code.D_28_08.Filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import code.D_28_08.DAO.EmployeeToDb;
import code.D_28_08.Model.Employee;

/**
 * Application Lifecycle Listener implementation class InitListner
 *
 */
@WebListener
public class InitListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent serv)  { 
       
    java.util.List<Employee> l =new  EmployeeToDb().getAllEmployee();
    serv.getServletContext().setAttribute("userList", l);
    
    }
	
}
