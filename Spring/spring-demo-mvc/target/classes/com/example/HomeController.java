package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(name = "/")
	public String homeDispatcher() {
		return "home-view";
	}
}
