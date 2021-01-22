package com.ecom.dal;

import javax.persistence.*;


import org.springframework.lang.NonNull;

@Table(name="user")
@Entity
public class User {
	public User(){
		
	}
	
	public User(com.ecom.models.User user) {
		Name = user.getName();
		Age = user.getAge();
		EmailID = user.getEmail();
		Password = user.getPassword();
		Gender = user.isGender();
	}
	
	
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@NonNull
	private String Name;
	
	@NonNull
	private String EmailID;
	
	private String Password;
	private int Age;
	private boolean Gender;
	
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public boolean isGender() {
		return Gender;
	}
	public void setGender(boolean gender) {
		Gender = gender;
	}
	
	
	
	
	
}
