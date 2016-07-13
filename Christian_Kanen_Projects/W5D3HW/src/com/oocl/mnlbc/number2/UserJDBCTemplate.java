package com.oocl.mnlbc.number2;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String username, String password, String fname, String lname) {
		String SQL = "insert into RegisterUser (USERNAME, PASSWORD, FNAME, LNAME) values (?,?,?,?)";
		try {
			jdbcTemplateObject.update(SQL, username, password,fname, lname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Created Record Name = " + fname + " " + lname);
		return;
	}

	public User getUser(String uname) {
		String SQL = "select * from RegisterUser where USERNAME = ?";
		User user = jdbcTemplateObject.queryForObject(SQL, new Object[] { uname }, new UserMapper());
		return user;
	}

	public List<User> listUsers() {
		String SQL = "SELECT * FROM REGISTERUSER";
		List<User> users = jdbcTemplateObject.query(SQL, new UserMapper());
		return users;
	}

	public void delete(String uname) {
		String SQL = "delete from RegisterUser where USERNAME = ?";
		jdbcTemplateObject.update(SQL, uname);
		System.out.println("Deleted Record with Username = " + uname);
		return;
	}

	public void update(String uname, String fname, String lname, String password) {
		String SQL = "update RegisterUser set fname = ? , lname = ? , password = ? where USERNAME = ?";
		jdbcTemplateObject.update(SQL, fname, lname, password, uname);
		System.out.println("Updated Record with Username = " + uname);
		return;
	}
}