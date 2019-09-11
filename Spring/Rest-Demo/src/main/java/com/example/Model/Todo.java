package com.example.Model;

import java.util.Date;
import java.util.UUID;

public class Todo {

	private String id;
	private String disc;
	private Date date;
	public Todo() {
		super();
	}
	public String getId() {
		return id;
	}
		public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Todo( String disc, Date date) {
		super();
		this.id = UUID.randomUUID().toString();
		this.disc = disc;
		this.date = date;
	}
	
}
