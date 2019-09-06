package com.ibm.EmployeeMavenHibernetCRUD.Factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.EmployeeMavenHibernetCRUD.model.EmployeeModel;

public class FactoryConnection {
private FactoryConnection() {
	
}


public static SessionFactory getFactory() {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeModel.class).buildSessionFactory();
	return factory;
}


}
