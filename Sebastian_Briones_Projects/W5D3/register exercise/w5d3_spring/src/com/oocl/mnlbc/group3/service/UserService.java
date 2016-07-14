package com.oocl.mnlbc.group3.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.oocl.mnlbc.group3.dao.UserDAO;
import com.oocl.mnlbc.group3.model.User;
import com.oocl.mnlbc.group3.security.PasswordEncrypter;
import com.oocl.mnlbc.group3.security.PasswordEncrypter.CannotPerformOperationException;
import com.oocl.mnlbc.group3.mapper.UserMapper;

public class UserService implements UserDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean userExists(String username) {
		String sql = "SELECT 1 FROM USERS WHERE USERNAME = ?";
		User user = null;
		try {
			user = jdbcTemplateObject.queryForObject(sql, new Object[] { username }, new UserMapper());
		} catch (Exception e) {
			return false;
		}
		
		return user == null;
	}

	@Override
	public User validateAccount(String username, String password) {
		return null;
	}

	@Override
	public boolean registerUser(User user) {

		String username = user.getUserName();
		String userPassword = user.getUserPassword();
		String fullName = user.getFullName();
		String email = user.getEmail();
		String deliveryAddress = user.getAddress();
		String mobileNumber = user.getMobileNumber();
		String userRole = user.getUserRole();

		int rowsInserted = 0;

		String sql = "INSERT INTO USERS" + "(USERNAME," + "USER_PASSWORD," + "FULL_NAME," + "EMAIL," + "ADDRESS,"
				+ "MOBILE_NUMBER," + "USER_ROLE)" + "VALUES(?,?,?,?,?,?,?)";

		String enryptedPassword = "";
		try {
			enryptedPassword = PasswordEncrypter.createHash(userPassword);
		} catch (CannotPerformOperationException e1) {
			e1.printStackTrace();
		}

		try {
			rowsInserted = jdbcTemplateObject.update(sql, username, enryptedPassword, fullName, email, deliveryAddress,
					mobileNumber, userRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return rowsInserted > 0;
	}

	@Override
	public List<User> getBannedUsers() {
		return null;
	}

	@Override
	public boolean emailExists(String email) {
		return false;
	}

}
