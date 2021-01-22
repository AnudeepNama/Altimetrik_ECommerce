package com.ecom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.dal.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	User findByEmailIDandPassword(String email,String password);
}
