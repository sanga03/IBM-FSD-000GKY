package com.example.demo.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Notes;

@Repository
public interface NotesRepo extends JpaRepository<Notes, Integer>{

}
