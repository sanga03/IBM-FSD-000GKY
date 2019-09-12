package com.example.demo.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Ingredent;

@Repository
public interface IngredentRepo extends JpaRepository<Ingredent, Integer> {

}
