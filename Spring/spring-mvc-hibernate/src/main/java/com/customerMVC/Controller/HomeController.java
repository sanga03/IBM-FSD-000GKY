package com.customerMVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customerMVC.Entity.Customer;
import com.customerMVC.Entity.Sea;
import com.customerMVC.Services.CustomerServices;

@RequestMapping("/")
@Controller
public class HomeController {
	@Autowired
	private CustomerServices customerServices;

	@GetMapping("/")
	public String ListView(Model model) {
		List<Customer> lc = customerServices.getCustomers();
		for (Customer c : lc) {
			System.out.println(c);
		}
		Sea sea = new Sea();
		model.addAttribute("sea",sea);
		model.addAttribute("lists", lc);
		return "view-list";
		
	}

	@GetMapping("/addC")
	public String AddCustomer(Model model) {
//	CustomerServices customerServices = new  CustomerServices();
//	model.addAttribute("cserivice",customerServices);
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		System.out.println(customer);
		return "add-form";
	}

	@GetMapping("/edit")
	public String EditCustomer(Model model, @RequestParam("id") String id, @RequestParam("fname") String fname,
			@RequestParam("lname") String lname, @RequestParam("email") String email) {
		int idz = Integer.parseInt(id);
		System.out.println(id);
		Customer customer = new Customer(idz, fname, lname, email);
		System.out.println("------id" + customer.getId());
		model.addAttribute("editC", customer);
		model.addAttribute("id", new Integer(id));

		return "edit-form";
	}
@PostMapping("/search")
public String Search(Model model,@ModelAttribute("sea") Sea sea){
	List<Customer> lc= null;
if(sea.getStype().equals("Name")) {
lc	=	customerServices.searchByName(sea.getSname());
	
}else {
	lc= customerServices.searchByName(sea.getSname());
}
model.addAttribute("sea",sea);
model.addAttribute("lists", lc);
return "view-list";
}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") String id, @RequestParam("fname") String fname,
			@RequestParam("lname") String lname, @RequestParam("email") String email) {
		System.out.println(id);
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(email);
		int idz = Integer.parseInt(id);
		Customer customer = new Customer(fname, lname, email);
		System.out.println("in dele - " + customer);
		customerServices.deleteCustomer(idz);
		return "redirect:/";
	}

	@PostMapping("/postAdd")
	public String postAdd(@ModelAttribute("customer") Customer theCustomer) {
		customerServices.createCustomer(theCustomer);
		return "redirect:/";
	}

	@PostMapping("/postEdit")
	public String postEdit(@ModelAttribute("editC") Customer theCustomer) {

//	System.out.println("Post Edit"+id);
		System.out.println(theCustomer.getId());
		customerServices.updateCustomer(theCustomer);
		return "redirect:/";
	}
}
