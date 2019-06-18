package com.dao;

import com.model.User;

public interface UserDAO 
{

	void signup(User user);
	boolean login(String username,String password);
	
	
	
}
