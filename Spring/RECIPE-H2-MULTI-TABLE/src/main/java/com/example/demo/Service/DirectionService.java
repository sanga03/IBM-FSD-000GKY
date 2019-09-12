package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Repositry.DirectionRepo;

@Service
public class DirectionService {
private DirectionRepo directionRepo;

public DirectionService(DirectionRepo directionRepo) {
	super();
	this.directionRepo = directionRepo;
}

public DirectionService() {
	super();
}

	
}
