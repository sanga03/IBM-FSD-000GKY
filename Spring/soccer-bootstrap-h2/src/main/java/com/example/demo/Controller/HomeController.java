package com.example.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.League;
import com.example.demo.Service.LeagueService;

@Controller
@RequestMapping("/leagues")
public class HomeController {
	LeagueService leagueService;
	
	public HomeController(LeagueService leagueService) {
		super();
		this.leagueService = leagueService;
	}

	@RequestMapping("/")
	public String list(Model model) {
		List<League> league = leagueService.getLeagues();
		model.addAttribute("ll",league);
		return "/league/list";
	}
	@RequestMapping("/save")
	public String saveForm(@ModelAttribute("ll") League league) {
		leagueService.saveLeague(league);
		return "redirect:/leagues/";
	}
	@RequestMapping("/addForm")
	public String giveForm(Model model) {
		League league = new League();
		model.addAttribute("ll",league);
		return "/league/add-form";
	}
	@GetMapping("/edit")
	public String editForm(Model model,@RequestParam("id") Integer id) {
		League league = leagueService.getbyId(id);
		model.addAttribute("ll",league);
		return "/league/add-form";	
	}
	@GetMapping("/delete")
	public String deleteForm(@RequestParam("id") Integer id) {
		leagueService.deleteLeague(id);
		return "redirect:/leagues/";
		
	}
	
}
