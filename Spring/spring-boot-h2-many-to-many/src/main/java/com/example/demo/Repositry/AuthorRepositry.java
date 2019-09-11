package com.example.demo.Repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Author;

@Repository
public interface AuthorRepositry extends CrudRepository<Author, Long> {

}
