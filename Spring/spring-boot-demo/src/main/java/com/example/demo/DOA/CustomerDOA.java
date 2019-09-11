package com.example.demo.DOA;


import java.util.List;

import com.example.demo.Entity.Customer;

public interface CustomerDOA {
	public void createCustomer(Customer customer);

	public List<Customer> getCustomers();

	public List<Customer> searchByName(String name);

	public List<Customer> searchByEmail(String email);

	public void deleteCustomer(int id);

	public void updateCustomer(Customer ciCustomer);

	public Customer getByID(int id);
}
