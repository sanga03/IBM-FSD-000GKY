package com.example.demo.Repositry;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Book;

public interface BookRepositry extends CrudRepository<Book,Long> {

}
