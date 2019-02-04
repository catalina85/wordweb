package com.learn.word.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.learn.word.db.JDBCUtils;

public class TestGetGeneratedKeys {
	@Test
	public void gg() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCUtils.getConnection();
			String sql = "INSERT INTO test (test1) VALUES (?) ";
			String generatedColumns[] = { "NID","test2" };
			//stmt = con.prepareStatement(query, generatedColumns);
			preparedStatement = connection.prepareStatement(sql, generatedColumns);

			preparedStatement.setObject(1,"haha");

			preparedStatement.executeUpdate();
			
	

			// ��ȡ���ɵ�����ֵ
			resultSet = preparedStatement.getGeneratedKeys();
			int id = 0;
			String test2 = null;
			if (resultSet.next()) {
				id =  resultSet.getInt(1);
				test2 = resultSet.getString(2);
			}
			System.out.println(id);
			System.out.println(test2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(resultSet, preparedStatement);
		}
	}
}
