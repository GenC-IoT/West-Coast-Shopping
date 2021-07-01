package com.example.demo;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class JdbcCustomerDao implements CustomerDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void insert(Customer c) {
		String sql = "INSERT INTO CUSTOMERS (CUSTOMERID, COMPANYNAME, CONTACTNAME, STREET, CITY, STATE) VALUES(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, c.getCustomerID());
				ps.setString(2, c.getCompanyName());
				ps.setString(3, c.getContactName());
				ps.setString(4, c.getStreet());
				ps.setString(5, c.getCity());
				ps.setString(6, c.getState());
			}
		});
		System.out.println("Inserted into Customer");
	}

	public void update(Customer c) {
		String sql = "UPDATE CUSTOMERS SET CUSTOMERID=?, COMPANYNAME=?, CONTACTNAME=?, STREET=?, CITY=?, STATE=? WHERE CUSTOMERID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, c.getCustomerID());
				ps.setString(2, c.getCompanyName());
				ps.setString(3, c.getContactName());
				ps.setString(4, c.getStreet());
				ps.setString(5, c.getCity());
				ps.setString(6, c.getState());
				ps.setString(7, c.getCustomerID());
			}
		});
		System.out.println("Updated Customer");
	}

	public void delete(Customer c) {
		String sql = "DELETE FROM CUSTOMERS WHERE CUSTOMERID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, c.getCustomerID());
			}
		});
		System.out.println("Deleted from Customer");
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
