package com.example.demo.Entity;

import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRecipenotes() {
		return recipenotes;
	}
	public void setRecipenotes(String recipenotes) {
		this.recipenotes = recipenotes;
	}
	private String recipenotes;
}
