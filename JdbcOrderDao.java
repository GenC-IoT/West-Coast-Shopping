package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcOrderDao implements OrderDao {

	private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_url = "jdbc:derby:C:\\Users\\Ian\\MyDB;create=true";

	private DataSource dataSource;
	private Connection conn;

	public void insert(Order o) {
		String sql = "INSERT INTO ORDERS (ORDERID, CUSTOMERID, ORDERDATE) VALUES(?, ?, ?)";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setInt(1, o.getOrderID());
			ps.setString(2, o.getCustomerID());
			ps.setString(3, o.getOrderDate());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Inserted into Orders");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Order o) {
		String sql = "UPDATE ORDERS SET ORDERID=?, CUSTOMERID=?, ORDERDATE=? WHERE ORDERID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setInt(1, o.getOrderID());
			ps.setString(2, o.getCustomerID());
			ps.setString(3, o.getOrderDate());
			ps.setInt(4, o.getOrderID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Updated Orders");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Order o) {
		String sql = "DELETE FROM ORDERS WHERE ORDERID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setInt(1, o.getOrderID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Deleted from Orders");
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
