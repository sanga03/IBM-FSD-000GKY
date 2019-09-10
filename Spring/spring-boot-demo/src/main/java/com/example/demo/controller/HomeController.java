package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Customer;
import com.example.demo.Services.CustomerServices;

@RestController
@RequestMapping("/")
public class HomeController {

	@Autowired
	private CustomerServices cservice;

	@GetMapping("/index")
	public String Home() {
		return "Hello";
	}

	@GetMapping("/customer")
	public List<Customer> getCustomer() {
		return cservice.getCustomers();
	}
}
