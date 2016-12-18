package com.gcit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public abstract class BaseDAO {
	
	protected Connection getConnection() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", 
				"root", "root");
		return conn;
	}

}






















