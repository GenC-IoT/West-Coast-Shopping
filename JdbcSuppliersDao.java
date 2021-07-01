package com.example.demo;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class JdbcSuppliersDao implements SuppliersDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void insert(Suppliers s) {
		String sql = "INSERT INTO SUPPLIERS (SUPPLIERID, COMPANYNAME, CONTACTNAME) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, s.getSupplierID());
				ps.setString(2, s.getCompanyName());
				ps.setString(3, s.getContactName());
			}
		});
		System.out.println("Inserted into Suppliers");
	}

	public void update(Suppliers s) {
		String sql = "UPDATE SUPPLIERS SET SUPPLIERID=?, COMPANYNAME=?, CONTACTNAME=? WHERE SUPPLIERID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, s.getSupplierID());
				ps.setString(2, s.getCompanyName());
				ps.setString(3, s.getContactName());
				ps.setLong(4, s.getSupplierID());
			}
		});
		System.out.println("Updated Suppliers");
	}

	public void delete(Suppliers s) {
		String sql = "DELETE FROM SUPPLIERS WHERE SUPPLIERID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, s.getSupplierID());
			}
		});
		System.out.println("Deleted from Suppliers");
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
