package com.example.demo;

//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class JdbcProductDao implements ProductDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void insert(Product p) {
		String sql = "INSERT INTO PRODUCTS (PRODUCTID, PRODUCTNAME, SUPPLIERID, CATEGORYID, UNITPRICE) VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, p.getProductID());
				ps.setString(2, p.getProductName());
				ps.setLong(3, p.getSupplierID());
				ps.setLong(4, p.getCategoryID());
				ps.setDouble(5, p.getUnitPrice());
			}
		});
		System.out.println("Inserted into OrderDetails");
	}

	public void update(Product p) {
		String sql = "UPDATE PRODUCTS SET PRODUCTID=?, PRODUCTNAME=?, SUPPLIERID=?, CATEGORYID=?, UNITPRICE=? WHERE PRODUCTID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, p.getProductID());
				ps.setString(2, p.getProductName());
				ps.setLong(3, p.getSupplierID());
				ps.setLong(4, p.getCategoryID());
				ps.setDouble(5, p.getUnitPrice());
				ps.setLong(6, p.getProductID());
			}
		});
		System.out.println("Updated OrderDetails");
	}
	

	public void delete(Product p) {
		String sql = "DELETE FROM PRODUCTS WHERE PRODUCTID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, p.getProductID());
			}
		});
		System.out.println("Deleted from Categories");
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
