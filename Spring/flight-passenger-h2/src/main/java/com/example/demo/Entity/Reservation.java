package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Reservation {
	@Id
	private int passenger_id,flight_id;

	
	
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	
	public Reservation(int passenger_id, int flight_id) {
		super();
		this.passenger_id = passenger_id;
		this.flight_id = flight_id;
		
	}
	public Reservation() {
		super();
	}


}
