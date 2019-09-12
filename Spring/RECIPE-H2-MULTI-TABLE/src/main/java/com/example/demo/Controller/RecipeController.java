package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
@RequestMapping("/view/{id}")
	public String viewReicpe(@RequestParam("id") Integer id,Model model)
	{
		
		return "/recipe/view";
		
	}
}
