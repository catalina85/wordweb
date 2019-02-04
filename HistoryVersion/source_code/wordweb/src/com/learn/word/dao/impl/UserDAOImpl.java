package com.learn.word.dao.impl;

import com.learn.word.dao.UserDAO;
import com.learn.word.domain.User;

public class UserDAOImpl extends BaseDAO<User>implements UserDAO {



	@Override
	public User getUser(String username, String password) {
		String sql = "SELECT USERNAME \"username\",PASSWORD \"password\" FROM users where USERNAME = ? and PASSWORD = ?";
		return query(sql,username,password);
	}

}
