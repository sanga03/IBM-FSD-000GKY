package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.League;
import com.example.demo.Repositry.LeagueRepositry;

@Service
public class LeagueService {
	private LeagueRepositry leagueRepositry;

	public LeagueService(LeagueRepositry leagueRepositry) {
		super();
		this.leagueRepositry = leagueRepositry;
	}

	public List<League> getLeagues() {
		List<League> leagues = new ArrayList<League>();
		for (League l : leagueRepositry.findAll()) {
			leagues.add(l);
		}
		return leagues;
	}

	public League getbyId(int id) {
		return leagueRepositry.findById(id).get();
	}

	public void saveLeague(League league) {
		leagueRepositry.save(league);
	}

	public void updateLeague(League league) {
		
		leagueRepositry.save(league);
		
	}

	public void deleteLeague(int id) {
		leagueRepositry.deleteById(id);
	}
}
