package com.learn.word.service;

import com.learn.word.dao.UserDAO;
import com.learn.word.dao.impl.UserDAOImpl;
import com.learn.word.domain.User;

public class UserService {
	UserDAO userDAO = new UserDAOImpl();
	
	public User getUser(String username,String password){
		return userDAO.getUser(username, password);
		
	}
}
