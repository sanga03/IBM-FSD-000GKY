package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Recipe;
import com.example.demo.Service.DirectionService;
import com.example.demo.Service.IngredentService;
import com.example.demo.Service.NotesService;
import com.example.demo.Service.RecipeService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	private RecipeService recipeService;
	private NotesService notesService;
	private IngredentService ingredentService;
	private DirectionService directionService;
	
public RecipeController(RecipeService recipeService, NotesService notesService, IngredentService ingredentService,
			DirectionService directionService) {
		super();
		this.recipeService = recipeService;
		this.notesService = notesService;
		this.ingredentService = ingredentService;
		this.directionService = directionService;
	}

@GetMapping("/view/{id}")
	public String viewReicpe(@RequestParam("id") Integer id,Model model)
	{
		Recipe recipe = recipeService.getById(id);
		model.addAttribute("recipe",recipe);
		return "view";
		
	}
}
