package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@PostMapping("/save")
public void savePlayer(@RequestBody Player player) {
	playerService.savePlayer(player);
}
@PostMapping("/update")
public void updatePlayer(@RequestBody Player player) {
	playerService.savePlayer(player);
}
@GetMapping("/delete/{id}")
public void deletePlayer(@PathVariable("id") int id) {
	Player player = playerService.findById(id);
	playerService.deletePlayer(player);
}
@GetMapping("/get/{id}")
public Player findPlayer(@PathVariable("id") int id) {
	return playerService.findById(id);
}
}
