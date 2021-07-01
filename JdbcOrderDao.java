package com.example.demo;

//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class JdbcOrderDao implements OrderDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void insert(Order o) {
		String sql = "INSERT INTO ORDERS (ORDERID, CUSTOMERID, ORDERDATE) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, o.getOrderID());
				ps.setString(2, o.getCustomerID());
				ps.setString(3, o.getOrderDate());
			}
		});
		System.out.println("Inserted into Categories");
	}

	public void update(Order o) {
		String sql = "UPDATE ORDERS SET ORDERID=?, CUSTOMERID=?, ORDERDATE=? WHERE ORDERID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, o.getOrderID());
				ps.setString(2, o.getCustomerID());
				ps.setString(3, o.getOrderDate());
				ps.setInt(4, o.getOrderID());
			}
		});
		System.out.println("Updated Categories");
	}
	
	public void delete(Order o) {
		String sql = "DELETE FROM ORDERS WHERE ORDERID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, o.getOrderID());
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
