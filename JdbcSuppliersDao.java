package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcSuppliersDao implements SuppliersDao {

	private static final String Driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_url = "jdbc:derby:C:\\Users\\Ian\\MyDB;create=true";

	private DataSource dataSource;
	private Connection conn;

	public void insert(Suppliers s) {
		String sql = "INSERT INTO SUPPLIERS (SUPPLIERID, COMPANYNAME, CONTACTNAME) VALUES(?, ?, ?)";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			//set the prepared statement values
			ps.setLong(1, s.getSupplierID());
			ps.setString(2, s.getCompanyName());
			ps.setString(3, s.getContactName());
			//execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Inserted into Suppliers");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Suppliers s) {
		String sql = "UPDATE SUPPLIERS SET SUPPLIERID=?, COMPANYNAME=?, CONTACTNAME=? WHERE SUPPLIERID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setLong(1, s.getSupplierID());
			ps.setString(2, s.getCompanyName());
			ps.setString(3, s.getContactName());
			ps.setLong(4, s.getSupplierID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Updated Suppliers");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Suppliers s) {
		String sql = "DELETE FROM SUPPLIERS WHERE SUPPLIERID=?";
		try {
			this.conn = DriverManager.getConnection(JDBC_url);
			PreparedStatement ps = conn.prepareStatement(sql);
			// set the prepared statement values
			ps.setLong(1, s.getSupplierID());
			// execute
			ps.executeUpdate();
			ps.close();
			System.out.println("Deleted from Suppliers");
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
