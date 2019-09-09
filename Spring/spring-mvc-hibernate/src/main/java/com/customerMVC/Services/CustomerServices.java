package com.customerMVC.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerMVC.DOA.CustomerDOA;
import com.customerMVC.Entity.Customer;

@Service
public class CustomerServices  implements CustomerDOA{

	@Autowired
	private CustomerDOA customerDOA;
	@Override
	public void createCustomer(Customer customer) {
		customerDOA.createCustomer(customer);
		
	}
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDOA.getCustomers();
	}
	@Override
	public void deleteCustomer(int  customer) {
		System.out.println("in delete");
		customerDOA.deleteCustomer(customer);
	}
	@Override
	public void updateCustomer(Customer ciCustomer) {
		customerDOA.updateCustomer(ciCustomer);
	}
	@Override
	public List<Customer> searchByName(String name) {
		return customerDOA.searchByName(name);
	}
	@Override
	public List<Customer> searchByEmail(String email) {
		// TODO Auto-generated method stub
		return customerDOA.searchByEmail(email);
	}

}
