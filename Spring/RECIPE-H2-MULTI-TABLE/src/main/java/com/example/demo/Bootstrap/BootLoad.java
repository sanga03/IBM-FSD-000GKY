package com.example.demo.Bootstrap;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Direction;
import com.example.demo.Entity.Ingredent;
import com.example.demo.Entity.Notes;
import com.example.demo.Entity.Recipe;
import com.example.demo.Repositry.DirectionRepo;
import com.example.demo.Repositry.IngredentRepo;
import com.example.demo.Repositry.NotesRepo;
import com.example.demo.Repositry.RecipeRepo;

@Component
public class BootLoad  implements ApplicationListener<ContextRefreshedEvent>{
private RecipeRepo recipeRepo;
private IngredentRepo ingredentRepo; 
private NotesRepo notesRepo;
private DirectionRepo directionRepo;

	public BootLoad(RecipeRepo recipeRepo, IngredentRepo ingredentRepo, NotesRepo notesRepo, DirectionRepo directionRepo) {
	super();
	this.recipeRepo = recipeRepo;
	this.ingredentRepo = ingredentRepo;
	this.notesRepo = notesRepo;
	this.directionRepo = directionRepo;
}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		inti();
	}

	private void inti() {
		Recipe recipe =new Recipe();
		recipe.setCooktime("12");
		recipe.setDescription("Halwa");
		Ingredent ingredents = new Ingredent();
		ingredents.setDesc("sugar");
		ingredents.setAmount(500);
		ingredents.setRecipe(recipe);
		Ingredent ingredent = new Ingredent();
		ingredent.setDesc("gajar");
		ingredent.setAmount(500);
		ingredent.setRecipe(recipe);
		System.out.println(ingredents);
		recipe.getIngredent().add(ingredents);
		Notes notes=new Notes();
		notes.setRecipenotes("add more chilly");
		recipe.setNotes(notes);
		Direction direction = new Direction();
		direction.setDirections("boil more water");
		recipeRepo.save(recipe);
		directionRepo.save(direction);
		ingredentRepo.save(ingredents);

		ingredentRepo.save(ingredent);
		notesRepo.save(notes);
		
	}
	

}
