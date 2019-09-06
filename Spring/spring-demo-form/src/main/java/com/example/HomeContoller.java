package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeContoller {
	
@GetMapping("/")
public String getHome(){
	return "home-view";
}
}
