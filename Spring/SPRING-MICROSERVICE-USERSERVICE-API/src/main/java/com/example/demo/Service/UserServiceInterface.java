package com.example.demo.Service;

import java.util.List;

import com.example.demo.Shared.UserDto;

public interface UserServiceInterface {
public UserDto createUser(UserDto userDto);
public UserDto findbyId(String userid);
public boolean deleteById(String userid);
public List<UserDto> searchbyfname(String fname);
public List<UserDto> searchbyemail(String email);
}
