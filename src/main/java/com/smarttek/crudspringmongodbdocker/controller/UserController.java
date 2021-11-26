package com.smarttek.crudspringmongodbdocker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarttek.crudspringmongodbdocker.model.User;
import com.smarttek.crudspringmongodbdocker.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	// create a new user
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		try {
			User usernew = userRepository.save(user);
			return new ResponseEntity<>(usernew, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// retreive all users
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {

			List<User> users = new ArrayList<User>();

			userRepository.findAll().forEach(users::add);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// retreive user by id
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
		try {
			User user = new User();
			user = userRepository.findUserById(id);
			if (user == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// retreive users by firstname
	@GetMapping("/users/firstname/{firstname}")
	public ResponseEntity<List<User>> getUsersByFirstname(@PathVariable("firstname") String firstname) {
		try {

			List<User> users = new ArrayList<User>();

			userRepository.findUserByFirstName(firstname).forEach(users::add);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// retreive users by lastname
	@GetMapping("/users/lastname/{lastname}")
	public ResponseEntity<List<User>> getUsersByLastname(@PathVariable("lastname") String lastname) {
		try {

			List<User> users = new ArrayList<User>();

			userRepository.findUserByLastName(lastname).forEach(users::add);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// retreive users by age
	@GetMapping("/users/age/{age}")
	public ResponseEntity<List<User>> getUsersByAge(@PathVariable("age") String age) {
		try {

			List<User> users = new ArrayList<User>();

			userRepository.findUserByAge(age).forEach(users::add);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//update User
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
		User userfound = userRepository.findUserById(id);

	  if (userfound == null) {
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   
	  } else {
		  userfound.setFirstName(user.getFirstName());
		  userfound.setLastName(user.getLastName());
		  userfound.setAge(user.getAge());
		    return new ResponseEntity<>(userRepository.save(userfound), HttpStatus.OK);
	  }
	}
	// delete User
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
	  try {
	    userRepository.deleteById(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}

	@DeleteMapping("/users")
	public ResponseEntity<HttpStatus> deleteAllUsers() {
	  try {
	    userRepository.deleteAll();
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
}
