package com.learn.word.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.learn.word.dao.DAO;
import com.learn.word.db.JDBCUtils;
import com.learn.word.utils.ReflectionUtils;

public class BaseDAO<T> implements DAO<T>{
	
	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;
	
	public BaseDAO() {
		clazz = ReflectionUtils.getSuperGenericType(getClass());
	}

	@Override
	public void update(String sql, Object... args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		
		try {
			connection = JDBCUtils.getConnection();
			queryRunner.update(connection, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public T query(String sql, Object... args) {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz) , args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<T> queryForList(String sql, Object... args) {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public <E> E getSingelValue(String sql, Object... args) {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("haha");
			e.printStackTrace();
			System.out.println("haha");
		}
		
		return null;
	}

	@Override
	public void batch(String sql, Object[]... params) {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			connection.setAutoCommit(false);
			queryRunner.batch(connection,sql, params);
			connection.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
