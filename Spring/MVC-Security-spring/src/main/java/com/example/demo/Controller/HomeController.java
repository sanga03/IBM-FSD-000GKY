package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
@GetMapping("/")
	public String getHome() {
		return "/home";
	}
@GetMapping("/login")
public String loginForm() {
	return "/login";
}
@PostMapping("/logprocess")
public String loginFormAuth() {
	return "/home";
}
}
