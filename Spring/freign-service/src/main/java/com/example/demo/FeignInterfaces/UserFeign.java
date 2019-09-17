package com.example.demo.FeignInterfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Model.CreateUserResponseModel;

@FeignClient(name="user-ws")
public interface UserFeign {
@GetMapping("/uid{userid}")
public CreateUserResponseModel findbyId(@PathVariable("userid")  String userid);
@GetMapping("/searchbyemail/{email}")
public List<CreateUserResponseModel> searchByEmail(@PathVariable("email") String email);
}
