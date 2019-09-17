package com.example.demo.Interfacce;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.Player;

@FeignClient(name="player" ,url ="http://localhost:8762/player")
public interface PlayerInterface {
	@GetMapping("/")
	public List<Player> getPlayers();
	@PostMapping("/save")
	public void savePlayer(@RequestBody Player player);
	@PostMapping("/update")
	public void updatePlayer(@RequestBody Player player);
	@GetMapping("/delete/{id}")
	public void deletePlayer(@PathVariable("id") int id);
	@GetMapping("/get/{id}")
	public Player findPlayer(@PathVariable("id") int id);
}
