package com.example.demo.Interfacce;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Model.Player;

@FeignClient(name="player" ,url ="http://localhost:8762/player")
public interface PlayerInterface {
	@GetMapping("/")
	public List<Player> getPlayers();
}
