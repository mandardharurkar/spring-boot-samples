package com.ucan.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ucan.userservice.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	public User findOneByName(String name);

}
