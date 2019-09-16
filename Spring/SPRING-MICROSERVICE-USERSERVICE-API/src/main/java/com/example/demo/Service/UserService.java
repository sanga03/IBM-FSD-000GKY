package com.example.demo.Service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Shared.UserDto;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto userDto) {

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userDto.setuser_id(UUID.randomUUID().toString());
		UserEntity userEntity = mapper.map(userDto, UserEntity.class);
		userRepo.save(userEntity);
		UserDto tempDto = mapper.map(userEntity, UserDto.class);
		return tempDto;
	}

}
