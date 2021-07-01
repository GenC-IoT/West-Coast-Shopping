package com.example.demo;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class JdbcCategoriesDao implements CategoriesDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void insert(Categories c) {
		String sql = "INSERT INTO CATEGORIES (CATEGORYID, CATEGORYNAME, DESCRIPTION) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, c.getCategoryID());
				ps.setString(2, c.getCategoryName());
				ps.setString(3, c.getDescription());
			}
		});
		System.out.println("Inserted into Categories");
	}

	public void update(Categories c) {
		String sql = "UPDATE CATEGORIES SET CATEGORYID=?, CATEGORYNAME=?, DESCRIPTION=? WHERE CATEGORYID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, c.getCategoryID());
				ps.setString(2, c.getCategoryName());
				ps.setString(3, c.getDescription());
				ps.setLong(4, c.getCategoryID());
			}
		});
		System.out.println("Updated Categories");
	}

	public void delete(Categories c) {
		String sql = "DELETE FROM CATEGORIES WHERE CATEGORYID=?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, c.getCategoryID());
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
