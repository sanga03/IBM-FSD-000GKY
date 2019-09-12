package com.example.demo.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Recipe;
@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Integer> {

}
