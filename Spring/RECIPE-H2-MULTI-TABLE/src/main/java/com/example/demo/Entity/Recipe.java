package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String cooktime;
	private String description;
	private String difficulty;
	private String preptime;
	private int serving;
	private String source;
	private String url;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe")
	private Set<Ingredent> ingredent;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "notesId")
	private Notes notes;
}
