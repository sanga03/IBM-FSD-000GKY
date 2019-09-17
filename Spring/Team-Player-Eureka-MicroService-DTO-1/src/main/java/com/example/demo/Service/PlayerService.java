package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Player;
import com.example.demo.Repo.TeamRepo;

@Service
public class PlayerService {
	@Autowired
	private TeamRepo playerRepo;
	public List<Player> getPlayers(){
		return playerRepo.findAll(); 
	}
	public Player findById(int id) {
		return playerRepo.findById(id).get();
	}
	public void savePlayer(Player player) {
		playerRepo.save(player);
	}
	public void deletePlayer(Player player) {
		playerRepo.delete(player);
	}
}
