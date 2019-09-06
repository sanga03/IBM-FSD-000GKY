package com.ibm.first_mavendemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.first_mavendemo.services.EmployeeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
       Employee emp = new Employee("sangamesh", "password", "sangu4403@gmail.com", "INDIA");
       EmployeeService employeeService = new EmployeeService();
       employeeService.addEmployee(emp);
       for(Employee e:employeeService.getEmployee()) {
    	   System.out.println(e);
       }
    }
}
