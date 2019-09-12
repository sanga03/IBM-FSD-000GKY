package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Recipe;
import com.example.demo.Repositry.RecipeRepo;

@Service
public class RecipeService {
	@Autowired
	private RecipeRepo recipeRepo;

	public RecipeService(RecipeRepo recipeRepo) {
		super();
		this.recipeRepo = recipeRepo;
	}

	public RecipeService() {
		super();
	}
	public Recipe getById(int id) {
		return recipeRepo.findById(id).get();
	}
	public List<Recipe> getAllRecipe() {
		return recipeRepo.findAll();
	}
}
