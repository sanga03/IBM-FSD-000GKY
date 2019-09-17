package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/")
public class HomeController {
	@GetMapping("/items")
	public String getItmes() {
	
		return "all-items";
	}
}
