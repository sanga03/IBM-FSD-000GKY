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
	private Clob recipenotes;
}
