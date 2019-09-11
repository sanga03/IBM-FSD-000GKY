package com.example.demo.Repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Flight;
@Repository
public interface FlightRepositry extends CrudRepository<Flight, Integer>{

}
