package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcOrderDetailsDao implements OrderDetailsDao{

	private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_url = "jdbc:derby:C:\\Users\\Ian\\MyDB;create=true";

	private DataSource dataSource;
	private Connection conn;
	
	public void insert(OrderDetails o) {
		String sql = "INSERT INTO ORDERDETAILS (ORDERID, PRODUCTID, QUANTITY) VALUES(?, ?, ?)";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setLong(1, o.getOrderId());
			ps.setLong(2, o.getProductID());
			ps.setShort(3, o.getQuantity());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Inserted into OrderDetails");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(OrderDetails o) {
		String sql = "UPDATE ORDERDETAILS SET ORDERID=?, PRODUCTID=?, QUANTITY=? WHERE ORDERID=? AND PRODUCTID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setLong(1, o.getOrderId());
			ps.setLong(2, o.getProductID());
			ps.setShort(3, o.getQuantity());
			ps.setLong(4, o.getOrderId());
			ps.setLong(5, o.getProductID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Updated OrderDetails");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(OrderDetails o) {
		String sql = "DELETE FROM ORDERDETAILS WHERE ORDERID=? AND PRODUCTID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setLong(1, o.getOrderId());
			ps.setLong(2, o.getProductID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Delete from Orderdetails");
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
