package com.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.models.User;
import com.ecom.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(path = "/loginMessage", produces = "application/json")
	public ResponseEntity<String> checkUserCredentials(){
		return new ResponseEntity<String>("Please login",HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/register", produces = "application/json",consumes = "application/json")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		User currentUserDetails = null;
		try {
			currentUserDetails = userService.addUser(user);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(currentUserDetails,HttpStatus.OK);
	}
	
	@PostMapping(path = "/login", produces = "application/json",consumes = "application/json")
	public ResponseEntity<User> checkUserCredentials(@RequestBody User user){
		User currentUserDetails = null;
		try {
			currentUserDetails = userService.checkUserCredentails(user);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(currentUserDetails,HttpStatus.OK);
	}
	
	@PostMapping(path = "/logout",produces = "application/json",consumes = "application/json")
	public ResponseEntity<User> logOut(@RequestBody User user){
		//Clear tokens/sessions if set.
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	
}
