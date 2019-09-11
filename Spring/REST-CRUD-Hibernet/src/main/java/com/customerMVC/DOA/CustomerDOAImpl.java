package com.customerMVC.DOA;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.customerMVC.Entity.Customer;

@Repository
public class CustomerDOAImpl implements CustomerDOA {
	private Session session;
	@Autowired
	private SessionFactory sessionFactory;

	@PostConstruct
	public void onCreate() {
		session = sessionFactory.openSession();
	}

	@Transactional
	public void createCustomer(Customer customer) {
		session.save(customer);
	}

	@SuppressWarnings("unchecked")

	@Transactional
	public List<Customer> getCustomers() {
		List<Customer> lc = new ArrayList<Customer>();
		Query rc = session.createQuery("from Customer");
		lc = rc.getResultList();
		return lc;
	}

	@Transactional
	public void deleteCustomer(int id) {
		Customer c = (Customer) session.load(Customer.class, id);
		System.out.println(c);
		session.beginTransaction();
		session.remove(c);
		session.getTransaction().commit();

	}

	public void updateCustomer(Customer ciCustomer) {
		System.out.println(ciCustomer.getId());
		session.beginTransaction();
		session.merge(ciCustomer);
		session.getTransaction().commit();

	}

	@Transactional
	public List<Customer> searchByName(String name) {
		List<Customer> lc = new ArrayList<Customer>();
		Query rc = session.createQuery("from Customer where fname like %" + name + "%");
		lc = rc.getResultList();
		return lc;
	}

	@Transactional
	public List<Customer> searchByEmail(String email) {
		List<Customer> lc = new ArrayList<Customer>();
		Query rc = session.createQuery("from Customer where fname like %" + email + "%");
		lc = rc.getResultList();
		return lc;
	}

	public Customer getByID(int id) {
		Query rc = session.createQuery("from Customer where id ="+id);
		List<Customer> lc = rc.getResultList();
		return lc.get(0);
	}

}
