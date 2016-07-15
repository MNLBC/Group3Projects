package com.oocl.mnlbc.dao;

import java.util.List;
import javax.sql.DataSource;
import com.oocl.mnlbc.model.UserBean;


public interface UserDAO {
	
	public void setDataSource(DataSource ds);

	public boolean userExists(String username);

	public UserBean validateAccount(String username, String password);
	
	public boolean registerUser(UserBean user);
	
	public List<UserBean> getBannedUsers();

	boolean emailExists(String email);

}
