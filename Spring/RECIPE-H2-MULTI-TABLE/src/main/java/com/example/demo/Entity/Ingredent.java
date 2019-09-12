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

}
