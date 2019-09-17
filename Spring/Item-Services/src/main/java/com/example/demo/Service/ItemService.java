package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Item;
import com.example.demo.Repo.ItemRepo;
@Service
public class ItemService {
	@Autowired
	private ItemRepo itemRepo;

	public List<Item> getAllItem() {
		return itemRepo.findAll();
	}

	public List<Item> searchByItems(String name) {
		return itemRepo.findAllByNameContaining(name);
	}
}