package com.ibm.EmployeeMavenHibernetCRUD.doa;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ibm.EmployeeMavenHibernetCRUD.Factory.FactoryConnection;
import com.ibm.EmployeeMavenHibernetCRUD.Interfaces.ServiceMethods;
import com.ibm.EmployeeMavenHibernetCRUD.model.EmployeeModel;

public class EmployeeDoa implements ServiceMethods {
	private SessionFactory factory;

	public EmployeeDoa() {

		factory = FactoryConnection.getFactory();
	}

	@Override
	public void addEmployee(EmployeeModel empd) {
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.persist(empd);
		session.getTransaction().commit();
	}

	@Override
	public EmployeeModel getEmployee(int id) {
		EmployeeModel empd = null;
		Session session = factory.openSession();
		session.getTransaction().begin();
		empd = session.get(EmployeeModel.class, id);

		return empd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeModel> getEmployees() {
		Session session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from EmployeeModel");
		return query.getResultList();
	
	}

	@Override
	public void updateEmployee(EmployeeModel empd) {
		

	}

	@Override
	public void deleteEmployee(EmployeeModel empd) {
		Session session = factory.openSession();
		session.getTransaction().begin();
		session.remove(empd);
		session.getTransaction().commit();
	}

}
