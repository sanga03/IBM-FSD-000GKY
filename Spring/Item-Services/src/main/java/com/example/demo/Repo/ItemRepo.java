package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Item;

@Repository
public interface ItemRepo  extends JpaRepository<Item, Integer>{
	public List<Item> findAllByNameContaining(String name);
}
