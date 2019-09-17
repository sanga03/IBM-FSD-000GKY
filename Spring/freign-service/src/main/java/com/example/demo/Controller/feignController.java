package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.FreignServiceApplication;
import com.example.demo.FeignInterfaces.UserFeign;

@RestController
public class feignController {

	@Autowired
	private UserFeign userFeign;
	@GetMapping("/fetchUser/{userid}")
	 public ResponseEntity < ? > fetchProduct(@PathVariable("userid") String userid) {

	  return ResponseEntity.ok(userFeign.findbyId(userid));
	 }
	@GetMapping("/SearchByEmail/{email}")
	 public ResponseEntity < ? > searchProduct(@PathVariable("email") String email) {

	  return ResponseEntity.ok(userFeign.searchByEmail(email));
	 }

}
