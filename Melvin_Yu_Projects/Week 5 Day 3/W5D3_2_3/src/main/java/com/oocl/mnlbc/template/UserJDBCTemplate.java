package com.oocl.mnlbc.template;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.oocl.mnlbc.dao.UserDAO;

public class UserJDBCTemplate implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * DATABASE TABLE
	 */
	//create table melvinuser (username varchar(60),password varchar(60),fullname varchar(60),mobile varchar(60),email varchar(60));


	public void create(String userName, String password, String fullname, String mobile, String email) {
		String SQL = "insert into MELVINUSER (userName, password, fullname, mobile, email) values ('" + userName + "','"
				+ password + "','" + fullname + "','" + mobile + "','" + email + "')";
		jdbcTemplateObject.update(SQL);
		System.out.println(
				"Created Record Name = " + fullname + " " + mobile + " User name = " + userName + " Email = " + email);

	}
}
