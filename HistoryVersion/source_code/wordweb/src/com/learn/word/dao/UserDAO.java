package com.learn.word.dao;

import com.learn.word.domain.User;

public interface UserDAO {
	
	public abstract User getUser(String username,String password);
	
}
