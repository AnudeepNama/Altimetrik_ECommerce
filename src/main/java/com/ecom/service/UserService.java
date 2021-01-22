package com.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.models.*;
import com.ecom.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserModel(com.ecom.dal.User user) {
		User userModel = new User();
		userModel.setAge(user.getAge());
		userModel.setEmail(user.getEmailID());
		userModel.setGender(user.isGender());
		userModel.setName(user.getName());
		userModel.setId(user.getId());
		return userModel;
	}
	
	public User addUser(User newUser) {
		try {
			User user = getUserModel(userRepository.save(new com.ecom.dal.User(newUser)));
			return user;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User checkUserCredentails(User user) {
		try {
			return getUserModel(userRepository.findByEmailIDandPassword(user.getEmail(),user.getPassword()));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
