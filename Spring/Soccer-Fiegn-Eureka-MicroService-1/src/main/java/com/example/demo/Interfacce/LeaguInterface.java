package com.example.demo.Interfacce;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.League;

@FeignClient(name="soccer-league",url = "http://localhost:8762/league")
public interface LeaguInterface {
@GetMapping("/list")
public List<League> getLeague();
@PostMapping("/save")
public boolean saveForm(@RequestBody League league);
@PostMapping("/update")
public boolean updateForm(@RequestBody League league);
@GetMapping("/get/{id}")
public League editForm(@PathVariable("id") int id);
@GetMapping("/delete/{id}")
public boolean deleteForm(@PathVariable("id") Integer id);
}
