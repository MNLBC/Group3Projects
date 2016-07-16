package com.oocl.mnlbc.service;

import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.model.UserBean;
import com.oocl.mnlbc.security.PasswordEncrypter;
import com.oocl.mnlbc.security.PasswordEncrypter.CannotPerformOperationException;
import com.oocl.mnlbc.security.PasswordEncrypter.InvalidHashException;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserService implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private final static UserService userDAO = new UserService();

	public static UserService getInstance() {
		return userDAO;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean userExists(String username) {
		String sql = "SELECT 1 FROM USERS WHERE " + "USERNAME ='" + username + "'";
		// List<UserBean> users = jdbcTemplateObject.query(sql, new
		// UserMapper());
		UserBean user = jdbcTemplateObject.queryForObject(sql, new Object[] { username }, new UserMapper());

		if (!user.getUserName().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean emailExists(String email) {
		String sql = "SELECT 1 FROM USERS WHERE " + "EMAIL ='" + email + "'";
		// List<UserBean> users = jdbcTemplateObject.query(sql, new
		// UserMapper());
		UserBean user = jdbcTemplateObject.queryForObject(sql, new Object[] { email }, new UserMapper());

		if (!user.getEmail().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserBean validateAccount(String username, String password) {
		// UserBean user = null;
		String sql = "SELECT * FROM USERS WHERE " + "USERNAME ='" + username + "'" + "AND USER_PASSWORD ='" + password
				+ "'";
		UserBean user = jdbcTemplateObject.queryForObject(sql, new Object[] { username, password }, new UserMapper());
		
		if (!user.getUserName().equals("")) {
			String passwordHash = user.getUserPassword();

			try {
				if (PasswordEncrypter.verifyPassword(password, passwordHash)) {
					int id = user.getUserId();
					username = user.getUserName();
					String fullName = user.getFullName();
					String email = user.getEmail();
					String deliveryAddress = user.getAddress();
					String mobileNumber = user.getMobileNumber();
					String userRole = user.getUserRole();

					user = new UserBean(id, username, passwordHash, fullName, email, deliveryAddress, mobileNumber,
							userRole);
					return user;
				}
			} catch (CannotPerformOperationException e) {
				e.printStackTrace();
			} catch (InvalidHashException e) {
				e.printStackTrace();
			}
		}
		return null;	
	}

	@Override
	public boolean registerUser(UserBean user) {

		String username = user.getUserName();
		String userPassword = user.getUserPassword();
		String fullName = user.getFullName();
		String email = user.getEmail();
		String deliveryAddress = user.getAddress();
		String mobileNumber = user.getMobileNumber();
		String userRole = user.getUserRole();

		String sql = "INSERT INTO USERS" + "(USERNAME," + "USER_PASSWORD," + "FULL_NAME," + "EMAIL," + "ADDRESS,"
				+ "MOBILE_NUMBER," + "USER_ROLE)" + "VALUES(?,?,?,?,?,?,?)";

		String enryptedPassword = "";
		try {
			enryptedPassword = PasswordEncrypter.createHash(userPassword);
		} catch (CannotPerformOperationException e1) {
			e1.printStackTrace();
		}
		try {
			jdbcTemplateObject.update(sql, username, userPassword, fullName, email, deliveryAddress, mobileNumber,
					userRole);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<UserBean> getBannedUsers() {
		List<UserBean> bannedUsers = new ArrayList<UserBean>();
		// String sql = "SELECT USER_ID, USERNAME, USER_PASSWORD, FULL_NAME,
		// EMAIL,ADDRESS, MOBILE_NUMBER, USER_ROLE FROM USERS WHERE
		// IS_BLACKLISTED=? ";
		String sql = "SELECT USER_ID, USERNAME, USER_PASSWORD, FULL_NAME, EMAIL,ADDRESS, MOBILE_NUMBER, USER_ROLE FROM USERS WHERE IS_BLACKLISTED='YES'";
		List<UserBean> users = jdbcTemplateObject.query(sql, new UserMapper());
		// List<UserBean> users = jdbcTemplateObject.query(sql, new
		// UserMapper());
		if (!users.isEmpty()) {
			for (UserBean user : users) {
				bannedUsers.add(new UserBean(user.getUserId(), user.getUserName()));
			}
		}

		return bannedUsers;
	}

}
