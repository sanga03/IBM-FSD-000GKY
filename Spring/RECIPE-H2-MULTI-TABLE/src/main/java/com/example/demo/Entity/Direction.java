package com.example.demo.Entity;

import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Direction {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDirections() {
	return Directions;
}
public void setDirections(String directions) {
	Directions = directions;
}
private String Directions;
}
