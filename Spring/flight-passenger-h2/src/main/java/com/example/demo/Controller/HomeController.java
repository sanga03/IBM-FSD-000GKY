package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class HomeController {
	@RequestMapping("/res")
	public String getAllBooks(Model theModel)
	{
		
		return "res";
	}

}
