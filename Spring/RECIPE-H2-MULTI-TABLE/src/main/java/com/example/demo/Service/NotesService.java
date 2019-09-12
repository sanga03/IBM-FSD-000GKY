package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Repositry.NotesRepo;

@Service
public class NotesService {
private NotesRepo notesRepo;

public NotesService(NotesRepo notesRepo) {
	super();
	this.notesRepo = notesRepo;
}

public NotesService() {
	super();
}

}
