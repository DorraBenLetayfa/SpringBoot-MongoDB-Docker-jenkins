package com.smarttek.crudspringmongodbdocker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smarttek.crudspringmongodbdocker.model.User;


public interface UserRepository extends MongoRepository<User, String>{
	User findUserById(String id);
	List<User> findUserByAge(String age);
	List<User> findUserByFirstName(String firstName);
	List<User> findUserByLastName(String lastName);
	

}
