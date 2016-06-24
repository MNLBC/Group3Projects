package com.oocl.mnlbc.group3.dao;

import com.oocl.mnlbc.group3.model.Account;

public interface AccountDAO {

	public boolean registerAccount(Account account);

	public boolean validateAccount(String username, String password);
	
	public boolean saveChatHistory();
	
	public boolean addUserChatAssn();

	boolean checkIfUserExist(String username);
	

}
