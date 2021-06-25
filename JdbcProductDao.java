package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcProductDao implements ProductDao{

	private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_url = "jdbc:derby:C:\\Users\\Ian\\MyDB;create=true";
	
	private DataSource dataSource;
	private Connection conn;
	
	public void insert(Product p) {
		String sql = "INSERT INTO PRODUCTS (PRODUCTID, PRODUCTNAME, SUPPLIERID, CATEGORYID, UNITPRICE) VALUES(?, ?, ?, ?, ?)";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			//set the prepared statement values
			ps.setLong(1, p.getProductID());
			ps.setString(2, p.getProductName());
			ps.setLong(3, p.getSupplierID());
			ps.setLong(4, p.getCategoryID());
			ps.setDouble(5, p.getUnitPrice());
			//execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Inserted into Products");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Product p) {
		String sql = "UPDATE PRODUCTS SET PRODUCTID=?, PRODUCTNAME=?, SUPPLIERID=?, CATEGORYID=?, UNITPRICE=? WHERE PRODUCTID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setLong(1, p.getProductID());
			ps.setString(2, p.getProductName());
			ps.setLong(3, p.getSupplierID());
			ps.setLong(4, p.getCategoryID());
			ps.setDouble(5, p.getUnitPrice());
			ps.setLong(6, p.getProductID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Updated Products");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Product p) {
		String sql = "DELETE FROM PRODUCTS WHERE PRODUCTID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setLong(1, p.getProductID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Deleted from Products");
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
