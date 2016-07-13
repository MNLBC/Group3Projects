package com.oocl.mnlbc.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String userName, String password, String fullName, String mobileNo, String emailAdd) {
		String SQL = "insert into users (USERNAME, PASSWORD, FULLNAME, MOBILENO, EMAILADD) values (?, ?, ?, ?, ?)";

		jdbcTemplateObject.update(SQL, userName, password, fullName, mobileNo, emailAdd);
		System.out.println(userName + " was successfully registered!");
		return;
	}

}