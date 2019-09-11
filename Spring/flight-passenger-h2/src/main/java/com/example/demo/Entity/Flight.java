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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String fromSrc;
	private String destination;
	private String fromTime;
	@ManyToMany
	//@JoinTable(name = "reservation", joinColumns = @JoinColumn(name = "flight_id"), inverseJoinColumns = @JoinColumn(name = "passenger_id"))
	@JoinTable
	@Fetch(FetchMode.SELECT)
	public Set<Passenger> passengers = new HashSet<Passenger>();

	public Flight(String name, String from, String destination, String fromTime, Set<Passenger> pasengers) {
		super();
		this.name = name;
		this.fromSrc = fromSrc;
		this.destination = destination;
		this.fromTime = fromTime;
		this.passengers = pasengers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getFromSrc() {
		return fromSrc;
	}

	public void setFromSrc(String fromSrc) {
		this.fromSrc = fromSrc;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

}
