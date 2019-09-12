package com.example.demo.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Direction;

@Repository
public interface DirectionRepo extends JpaRepository<Direction, Integer>{

}
