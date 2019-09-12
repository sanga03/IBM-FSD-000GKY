package com.example.demo.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Ingredent;
import com.example.demo.Entity.Recipe;

@Repository
public interface IngredentRepo extends JpaRepository<Ingredent, Integer> {
public List<Ingredent> findAllByRecipe(Recipe recipe);
}
