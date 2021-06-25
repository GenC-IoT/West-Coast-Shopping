package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcCategoriesDao implements CategoriesDao {

	private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_url = "jdbc:derby:C:\\Users\\Ian\\MyDB;create=true";

	private DataSource dataSource;
	private Connection conn;

	public void insert(Categories c) {
		String sql = "INSERT INTO CATEGORIES (CATEGORYID, CATEGORYNAME, DESCRIPTION) VALUES(?, ?, ?)";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setLong(1, c.getCategoryID());
			ps.setString(2, c.getCategoryName());
			ps.setString(3, c.getDescription());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Inserted into Categories");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Categories c) {
		String sql = "UPDATE CATEGORIES SET CATEGORYID=?, CATEGORYNAME=?, DESCRIPTION=? WHERE CATEGORYID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setLong(1, c.getCategoryID());
			ps.setString(2, c.getCategoryName());
			ps.setString(3, c.getDescription());
			ps.setLong(4, c.getCategoryID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Updated Categories");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Categories c) {
		String sql = "DELETE FROM CATEGORIES WHERE CATEGORYID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setLong(1, c.getCategoryID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Deleted from Categories");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public static String getDriver() {
		return Driver;
	}

	public static String getJdbcUrl() {
		return JDBC_url;
	}

}
