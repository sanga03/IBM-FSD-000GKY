package com.example.demo.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.League;
import com.example.demo.Service.LeagueService;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	LeagueService leagueService;

	@GetMapping("/list")
	public List<League> list() {
		List<League> league = leagueService.getLeagues();
		return league;
	}

	@PostMapping("/save")
	public boolean saveForm(@RequestBody League league) {
		leagueService.saveLeague(league);
		return true;
	}
	@PostMapping("/update")
	public boolean updateForm(@RequestBody League league) {
		leagueService.saveLeague(league);
		return true;
	}

	@GetMapping("/get/{id}")
	public League editForm(@PathVariable("id") int id) {
		League league = leagueService.getbyId(id);

		return league;
	}

	@GetMapping("/delete/{id}")
	public boolean deleteForm(@PathVariable("id") Integer id) {
		try {
			leagueService.deleteLeague(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
