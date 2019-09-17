package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
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
		userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		String spass = UUID.randomUUID().toString();
		System.out.println(spass);
		userDto.setUserid(spass);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = mapper.map(userDto, UserEntity.class);
		userRepo.save(userEntity);
		UserDto tempDto = mapper.map(userEntity, UserDto.class);
		return tempDto;
	}

	@Override
	public UserDto findbyId(String userid) {
		System.out.println("in dto"+userid);
		UserEntity userEntity = userRepo.findByUserid(userid);
		System.out.println(userEntity);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto tempDto = mapper.map(userEntity, UserDto.class);
		return tempDto;
	}

	@Override
	public boolean deleteById(String userid) {
	try {	
		UserEntity userEntity = userRepo.findByUserid(userid);
		userRepo.delete(userEntity);
		return true;
	}catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}

	@Override
	public List<UserDto> searchbyfname(String fname) {
	List<UserEntity> userEntities = userRepo.findAllByFnameContaining(fname);
	ModelMapper mapper = new ModelMapper();
	mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	List<UserDto> userDtos = new ArrayList<UserDto>();
	for(UserEntity userEntity:userEntities) {
	userDtos.add(mapper.map(userEntity, UserDto.class));
	}
	return userDtos;
	}

	@Override
	public List<UserDto> searchbyemail(String email) {
		List<UserEntity> userEntities = userRepo.findAllByEmailContaining(email);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for(UserEntity userEntity:userEntities) {
		userDtos.add(mapper.map(userEntity, UserDto.class));
		}
		return userDtos;
	}
}
