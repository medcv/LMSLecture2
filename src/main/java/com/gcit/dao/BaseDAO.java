package com.gcit.dao;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public abstract class BaseDAO {
	@Value("${spring.datasource.password}")
	String DBPassword;

	@Value("${spring.datasource.username}")
	String DBUsername;

	@Value("${spring.datasource.url}")
	String DBUrl;

	protected Connection getConnection() throws SQLException {
		
		try {

			System.out.println("DBPassword = " + DBPassword);
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = DriverManager.getConnection(
				DBUrl,
				DBUsername, DBPassword);
		return conn;
	}

}






















