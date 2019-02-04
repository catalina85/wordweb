package com.learn.word.dao;

import java.util.List;

public interface DAO<T> {

	void update(String sql, Object... args);
	
	T query(String sql, Object...args);
	
	List<T> queryForList(String sql, Object...args);
	
	<E> E getSingelValue(String sql,Object...args);
	
	void batch(String sql, Object[]...args);
}
