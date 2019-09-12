package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Ingredent;
import com.example.demo.Entity.Recipe;
import com.example.demo.Repositry.IngredentRepo;
import com.example.demo.Repositry.RecipeRepo;

@Service
public class IngredentService {
	@Autowired
private IngredentRepo ingredentRepo;
	@Autowired
	private RecipeRepo recipeRepo;
public IngredentService(IngredentRepo ingredentRepo) {
	super();
	this.ingredentRepo = ingredentRepo;
}

public IngredentService() {
	super();
}
public List<Ingredent> findByRecipeid(int rid){
	Recipe recipe = recipeRepo.findById(rid).get();
	return ingredentRepo.findAllByRecipe(recipe);
}
}
