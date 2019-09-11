package com.example.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
public Book(int isbn, String name) {
		super();
		this.isbn = isbn;
		this.name = name;
	}
private int isbn;
private String name;
@ManyToMany
@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
inverseJoinColumns = @JoinColumn(name = "author_id"))
public Set<Author> authors = new HashSet<>();
public Book(int isbn, String name, Set<Author> authors) {
	super();
	this.isbn = isbn;
	this.name = name;
	this.authors = authors;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<Author> getAuthors() {
	return authors;
}
public void setAuthors(Set<Author> authors) {
	this.authors = authors;
}
public Book() {
	super();
}


}
