package com.example.demo.Repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.League;

@Repository
public interface LeagueRepositry extends CrudRepository<League, Integer> {

}
