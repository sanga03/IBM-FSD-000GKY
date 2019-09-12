package com.example.demo.Entity;

import java.util.HashSet;
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
	private Set<Ingredent> ingredent = new HashSet<Ingredent>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCooktime() {
		return cooktime;
	}
	public void setCooktime(String cooktime) {
		this.cooktime = cooktime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getPreptime() {
		return preptime;
	}
	public void setPreptime(String preptime) {
		this.preptime = preptime;
	}
	public int getServing() {
		return serving;
	}
	public void setServing(int serving) {
		this.serving = serving;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set<Ingredent> getIngredent() {
		return ingredent;
	}
	public void setIngredent(Set<Ingredent> ingredent) {
		this.ingredent = ingredent;
	}
	public Notes getNotes() {
		return notes;
	}
	public void setNotes(Notes notes) {
		this.notes = notes;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "notesId")
	private Notes notes;
}
