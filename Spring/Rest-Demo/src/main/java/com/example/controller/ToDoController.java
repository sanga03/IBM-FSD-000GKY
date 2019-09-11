package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Todo;

@RestController
@RequestMapping("/api")
public class ToDoController {

private List<Todo> list=null;
	@PostConstruct
	public void createList()
	{
		list=new ArrayList<Todo>();
	}
	@GetMapping("/todos")
	public List<Todo> getAllToDo()
	{
		
		list.add(new Todo("Practice Spring Core",new Date()));
		list.add(new Todo("Learn Spring AOP", new Date()));
		return list;
	}

}
