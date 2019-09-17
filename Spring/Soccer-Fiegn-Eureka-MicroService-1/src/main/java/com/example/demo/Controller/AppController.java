package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Interfacce.LeaguInterface;
import com.example.demo.Interfacce.PlayerInterface;
import com.example.demo.Model.League;
import com.example.demo.Model.Player;

@Controller
public class AppController {
	@Autowired
	private LeaguInterface leaguInterface;
	@Autowired
	private PlayerInterface playerInterface;
@RequestMapping("/")
public String home() {
	return "home";
}

@RequestMapping("/fetchPlayers")
public String listPlayer(Model model) {
	List<Player> league =playerInterface.getPlayers();
	model.addAttribute("ll",league);
	return "/player/list";
}
	@RequestMapping("/fetchLeagues")
	public String list(Model model) {
		List<League> league =leaguInterface.getLeague();
		model.addAttribute("ll",league);
		return "/league/list";
	}
	
	@RequestMapping("/leagueSave")
	public String saveForm(@ModelAttribute("ll") League league) {
		leaguInterface.saveForm(league);
		return "redirect:/fetchLeagues/";
	}
	@RequestMapping("/leagueAddForm")
	public String giveForm(Model model) {
		League league = new League();
		model.addAttribute("ll",league);
		return "/league/add-form";
	}
	@GetMapping("/leagueEdit")
	public String editForm(Model model,@RequestParam("id") Integer id) {
	League league=	leaguInterface.editForm(id);
		model.addAttribute("ll",league);
		return "/league/add-form";	
	}
	@GetMapping("/leagueDelete")
	public String deleteForm(@RequestParam("id") Integer id) {
		leaguInterface.deleteForm(id);
		return "redirect:/fetchLeagues/";
		
	}
	@RequestMapping("/playerSave")
	public String savePlayer(@ModelAttribute("ll") Player league) {
		playerInterface.savePlayer(league);
		return "redirect:/fetchPlayers/";
	}
	@RequestMapping("/playerAddForm")
	public String givePlayer(Model model) {
		Player league = new Player();
		model.addAttribute("ll",league);
		return "/player/add-form";
	}
	@GetMapping("/playerEdit")
	public String editPlayer(Model model,@RequestParam("id") Integer id) {
	Player league=	playerInterface.findPlayer(id);
		model.addAttribute("ll",league);
		return "/player/add-form";	
	}
	@GetMapping("/playerDelete")
	public String deletePlayer(@RequestParam("id") Integer id) {
		playerInterface.deletePlayer(id);
		return "redirect:/fetchPlayers/";
		
	}
}
