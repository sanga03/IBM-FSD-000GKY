package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.UserEntity;
@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
public UserEntity findByUserid(String userid);
public List<UserEntity> findAllByEmailContaining(String email);
public List<UserEntity> findAllByFnameContaining(String fname);
}
