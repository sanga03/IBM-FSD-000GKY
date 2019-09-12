package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Recipe;
import com.example.demo.Repositry.RecipeRepo;

@Service
public class RecipeService {
private  RecipeRepo recipeRepo;

public RecipeService(RecipeRepo recipeRepo) {
	super();
	this.recipeRepo = recipeRepo;
}

public RecipeService() {
	super();
}
public List<Recipe> getAllRecipe(){
	return recipeRepo.findAll();
}
}
