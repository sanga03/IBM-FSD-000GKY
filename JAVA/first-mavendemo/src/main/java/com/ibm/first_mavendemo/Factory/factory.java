
package com.ibm.first_mavendemo.Factory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.first_mavendemo.Employee;

public class factory {
	
public static SessionFactory getfactory() {
	return  (SessionFactory)new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
    
}
}
