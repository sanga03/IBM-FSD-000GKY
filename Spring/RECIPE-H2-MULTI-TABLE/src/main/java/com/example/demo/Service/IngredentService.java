package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Repositry.IngredentRepo;

@Service
public class IngredentService {
private IngredentRepo ingredentRepo;
public IngredentService(IngredentRepo ingredentRepo) {
	super();
	this.ingredentRepo = ingredentRepo;
}

public IngredentService() {
	super();
}

}
