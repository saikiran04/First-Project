package com.niit.laptopsbackend.dao;

import java.util.List;

import com.niit.laptopsbackend.model.User;

public interface IUserDAO {
	 
	public boolean addUser(User user);
	
	public boolean deleteUser(User user);
	public User get(String email);
	public List<User>getAllUsers();

}
