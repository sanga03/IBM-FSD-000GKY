package com.example.demo.Entity;

import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Ingredent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int amount;
	private String Desc;
	@ManyToOne
	@JoinColumn
	private Recipe recipe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}
