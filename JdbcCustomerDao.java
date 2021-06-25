package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcCustomerDao implements CustomerDao {

	private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_url = "jdbc:derby:C:\\Users\\Ian\\MyDB;create=true";

	private DataSource dataSource;
	private Connection conn;

	public void insert(Customer c) {
		String sql = "INSERT INTO CUSTOMERS (CUSTOMERID, COMPANYNAME, CONTACTNAME, STREET, CITY, STATE) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setString(1, c.getCustomerID());
			ps.setString(2, c.getCompanyName());
			ps.setString(3, c.getContactName());
			ps.setString(4, c.getStreet());
			ps.setString(5, c.getCity());
			ps.setString(6, c.getState());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Inserted into Customers");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Customer c) {
		String sql = "UPDATE CUSTOMERS SET CUSTOMERID=?, COMPANYNAME=?, CONTACTNAME=?, STREET=?, CITY=?, STATE=? WHERE CUSTOMERID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setString(1, c.getCustomerID());
			ps.setString(2, c.getCompanyName());
			ps.setString(3, c.getContactName());
			ps.setString(4, c.getStreet());
			ps.setString(5, c.getCity());
			ps.setString(6, c.getState());
			ps.setString(7, c.getCustomerID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Updated Customers");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Customer c) {
		String sql = "DELETE FROM CUSTOMERS WHERE CUSTOMERID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setString(1, c.getCustomerID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Deleted from Customers");
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
