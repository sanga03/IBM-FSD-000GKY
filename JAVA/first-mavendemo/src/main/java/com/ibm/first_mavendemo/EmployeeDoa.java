package com.ibm.first_mavendemo;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ibm.first_mavendemo.Factory.factory;

public class EmployeeDoa {
	
	private SessionFactory factory1;
	public EmployeeDoa() {
	factory1=factory.getfactory();;
	}
	
public void addEmployee(Employee emp) {

	Session session = factory1.openSession();
	session.getTransaction().begin();
	session.persist(emp);
	session.getTransaction().commit();
}



@SuppressWarnings("unchecked")
public List<Employee> getEmployee(){
	Session session = factory1.openSession();
	Query query = session.createQuery("from Employee"); 	
	return query.getResultList();
}


}
