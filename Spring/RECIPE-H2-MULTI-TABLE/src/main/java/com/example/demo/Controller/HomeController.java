package com.example.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Ingredent;
import com.example.demo.Entity.Recipe;
import com.example.demo.Service.DirectionService;
import com.example.demo.Service.IngredentService;
import com.example.demo.Service.NotesService;
import com.example.demo.Service.RecipeService;

@Controller
@RequestMapping("/")
public class HomeController {


	private RecipeService recipeService;
	private NotesService notesService;
	private IngredentService ingredentService;
	private DirectionService directionService;
	
	public HomeController(RecipeService recipeService, NotesService notesService, IngredentService ingredentService,
			DirectionService directionService) {
		super();
		this.recipeService = recipeService;
		this.notesService = notesService;
		this.ingredentService = ingredentService;
		this.directionService = directionService;
	}
	@GetMapping("/")
	public String listMenu(Model model) {
	List<Recipe> recipes = recipeService.getAllRecipe();
	model.addAttribute("recipes",recipes);
		return "list-home";
		
	}
	@RequestMapping("/recipe/view")
	public String viewReicpe(@RequestParam("id") Integer id,Model model)
	{
		Recipe recipe = recipeService.getById(id);
		List<Ingredent> ings = ingredentService.findByRecipeid(id);
		model.addAttribute("recipe",recipe);
		model.addAttribute("ings",ings);
		return "/recipe/view";
		
	}
}
