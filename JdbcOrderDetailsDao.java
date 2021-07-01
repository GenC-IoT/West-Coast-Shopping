package com.example.demo;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class JdbcOrderDetailsDao implements OrderDetailsDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void insert(OrderDetails o) {
		String sql = "INSERT INTO ORDERDETAILS (ORDERID, PRODUCTID, QUANTITY) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, o.getOrderId());
				ps.setLong(2, o.getProductID());
				ps.setShort(3, o.getQuantity());
			}
		});
		System.out.println("Inserted into OrderDetails");
	}

	public void update(OrderDetails o) {
		String sql = "UPDATE ORDERDETAILS SET ORDERID=?, PRODUCTID=?, QUANTITY=? WHERE ORDERID=? AND PRODUCTID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, o.getOrderId());
				ps.setLong(2, o.getProductID());
				ps.setShort(3, o.getQuantity());
				ps.setLong(4, o.getOrderId());
				ps.setLong(5, o.getProductID());
			}
		});
		System.out.println("Updated OrderDetails");
	}

	public void delete(OrderDetails o) {
		String sql = "DELETE FROM ORDERDETAILS WHERE ORDERID=? AND PRODUCTID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, o.getOrderId());
				ps.setLong(2, o.getProductID());
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
