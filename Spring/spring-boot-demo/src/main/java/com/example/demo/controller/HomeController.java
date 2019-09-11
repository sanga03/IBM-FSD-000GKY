package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Customer;
import com.example.demo.Services.CustomerServices;

@RestController
@RequestMapping("/")
public class HomeController {

	@Autowired
	private CustomerServices customerServices;

	@GetMapping("/index")
	public String Home() {
		return "Hello";
	}

	@GetMapping("/customer")	
	public List<Customer> getCustomer() {
		return customerServices.getCustomers();
	}
	@PostMapping("/customer")
	public Customer addCustomers(@RequestBody Customer customer) {
		
		customerServices.updateCustomer(customer);
		return customer;
		
	}
	@DeleteMapping("/customer/{id}")
	public boolean deleteCustomer(@PathVariable int id) {
	customerServices.deleteCustomer(id);
		return true;
		
	}
	@PutMapping("/customer")
	public boolean updateCustomer(@RequestBody Customer customer) {
		customerServices.updateCustomer(customer);
		return true;
	}
	
	@GetMapping("/customer/{id}")
	public Customer getById(@PathVariable int id) {
		return customerServices.getByID(id);
	}
}
