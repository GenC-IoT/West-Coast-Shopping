package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_url = "jdbc:derby:C:\\Users\\Ian\\MyDB;create=true";

	Connection conn;

	DBConnection() {
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			if(this.conn != null) {
				System.out.println("Connection Successful");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
