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
}
