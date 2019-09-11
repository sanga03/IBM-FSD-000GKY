package com.example.demo.DOA;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Customer;

@Repository
public class CustomerDOAImpl implements CustomerDOA {
	private Session session;
	
	
	private EntityManager em;
	
	@Autowired
	public CustomerDOAImpl(EntityManager em) {
		super();
		this.em = em;
	}
	public CustomerDOAImpl() {
		super();
	}
	@Transactional
	public void createCustomer(Customer customer) {
		session = em.unwrap(Session.class);
		session.save(customer);
	}

	@SuppressWarnings("unchecked")

	@Transactional
	public List<Customer> getCustomers() {
		session = em.unwrap(Session.class);
		List<Customer> lc = new ArrayList<Customer>();
		Query rc = session.createQuery("from Customer");
		lc = rc.getResultList();
		return lc;
	}

	@Transactional
	public void deleteCustomer(int id) {
		session = em.unwrap(Session.class);
		
		Customer c = (Customer) session.load(Customer.class, id);
		System.out.println(c);
		session.beginTransaction();
		session.remove(c);
		session.getTransaction().commit();

	}

	public void updateCustomer(Customer ciCustomer) {
		session = em.unwrap(Session.class);
		
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
		session = em.unwrap(Session.class);
		
		Query rc = session.createQuery("from Customer where id =" + id);
		List<Customer> lc = rc.getResultList();
		return lc.get(0);
	}

}
