package com.oocl.mnlbc.group3.dao;

import java.util.List;

import com.oocl.mnlbc.group3.model.Account;
import com.oocl.mnlbc.group3.model.Chat;

/**
 * Interface class for all DB methods
 * 
 * @author brionse
 *
 */
public interface AccountDAO {

	public boolean registerAccount(Account account);

	public boolean validateAccount(String username, String password);

	public boolean saveChatHistory(Chat chat);

	boolean checkIfUserExist(String username);

	public List<Chat> getPreviousChat();

}
