package com.example.demo.Repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Passenger;

@Repository
public interface PassengerRepositry extends CrudRepository<Passenger,Integer> {

}
