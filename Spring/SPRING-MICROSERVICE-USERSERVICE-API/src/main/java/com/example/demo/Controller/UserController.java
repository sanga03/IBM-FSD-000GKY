package com.example.demo.Controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Model.CreateUserRequestModel;
import com.example.demo.Model.CreateUserResponseModel;
import com.example.demo.Service.UserService;
import com.example.demo.Shared.UserDto;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/")
	public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel userDetail) {
		
//		userDetail.setPassword(bCryptPasswordEncoder.encode(userDetail.getPassword()));
		System.out.println(userDetail.getEmail());
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity=mapper.map(userDetail, UserEntity.class);
		System.out.println(userEntity.getFname());
		UserDto userDto = mapper.map(userEntity, UserDto.class);
		
		UserDto temp = userService.createUser(userDto);
		CreateUserResponseModel model = mapper.map(temp, CreateUserResponseModel.class);
		return new ResponseEntity<CreateUserResponseModel>(model, HttpStatus.CREATED);
	}
}
