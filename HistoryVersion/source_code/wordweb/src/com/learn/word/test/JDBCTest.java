package com.learn.word.test;

import java.sql.Connection;

import org.junit.Test;

import com.learn.word.db.JDBCUtils;

public class JDBCTest {
	@Test
	public void testJDBC(){
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
	}
}
