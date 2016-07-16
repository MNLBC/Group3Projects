package com.oocl.mnlbc.service;

import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.model.UserBean;
import com.oocl.mnlbc.security.PasswordEncrypter;
import com.oocl.mnlbc.security.PasswordEncrypter.CannotPerformOperationException;
import com.oocl.mnlbc.security.PasswordEncrypter.InvalidHashException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserService implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean userExists(String username) {
		String sql = "SELECT 1 AS USER_COUNT FROM USERS WHERE " + "USERNAME ='" + username + "'";
		try{
			Integer userCount = jdbcTemplateObject.queryForObject(sql, new UserCheckerMapper());

			if (userCount.intValue()>0) {
				return true;
			} else {
				return false;
			}
		}
		catch(Exception e){
			return false;
		}

		
	}

	@Override
	public boolean emailExists(String email) {
		String sql = "SELECT 1 AS USER_COUNT FROM USERS WHERE " + "EMAIL ='" + email + "'";
		try{
			Integer userCount = jdbcTemplateObject.queryForObject(sql, new UserCheckerMapper());

			if (userCount.intValue()>0) {
				return true;
			} else {
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	
	}

	@Override
	public UserBean validateAccount(String username, String password) {
		String sql = "SELECT * FROM USERS WHERE " + "USERNAME ='" + username + "'";
		// + "AND USER_PASSWORD ='" + password + "'";
		UserBean user = jdbcTemplateObject.queryForObject(sql, new UserMapper());
		if (user != null) {
			
				String passwordHash = user.getUserPassword();

				try {
					if (PasswordEncrypter.verifyPassword(password, passwordHash)) {
						return user;
					}
				} catch (CannotPerformOperationException e) {
					e.printStackTrace();
				} catch (InvalidHashException e) {
					e.printStackTrace();
				}
			
			return null;
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

		int i = 0;

		String sql = "INSERT INTO USERS" + "(USERNAME," + "USER_PASSWORD," + "FULL_NAME," + "EMAIL," + "ADDRESS,"
				+ "MOBILE_NUMBER," + "USER_ROLE)" + "VALUES(?,?,?,?,?,?,?)";
		
		String enryptedPassword = "";
		try {
			enryptedPassword = PasswordEncrypter.createHash(userPassword);
		} catch (CannotPerformOperationException e1) {
			e1.printStackTrace();
		}
		try{
			i= jdbcTemplateObject.update(sql,username,userPassword,fullName,email,deliveryAddress,mobileNumber,userRole);
			
		}catch(DataAccessException e){
			  e.printStackTrace();
		}
		catch (Exception e) {
			  e.printStackTrace();
	      }
	
		if (!(i == 0)) {
			return true;
		}
		return false;
	}


	@Override
	public List<UserBean> getBannedUsers() {
		List<UserBean> bannedUsers = new ArrayList<UserBean>();
		String sql = "SELECT USER_ID, USERNAME, USER_PASSWORD, FULL_NAME, EMAIL,ADDRESS, MOBILE_NUMBER, USER_ROLE FROM USERS WHERE IS_BLACKLISTED='YES'";
		List<UserBean> users = jdbcTemplateObject.query(sql, new UserMapper());
		if (!users.isEmpty()) {
			for (UserBean user : users) {
				bannedUsers.add(new UserBean(user.getUserId(), user.getUserName()));
			}
		}
		return bannedUsers;
	}

}
