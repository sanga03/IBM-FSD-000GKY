package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Player;
import com.example.demo.Service.PlayerService;

@RestController
public class PlayerController {
	@Autowired
	private PlayerService playerService;
@GetMapping("/")
public List<Player> getPlayers(){
	return playerService.getPlayers();
}
}
