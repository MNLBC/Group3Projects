package com.oocl.mnlbc.group3.transaction;

import com.oocl.mnlbc.group3.dao.AccountDAOImpl;
import com.oocl.mnlbc.group3.model.Account;

public class RegistrationTransaction {
           AccountDAOImpl acctDao = AccountDAOImpl.getInstance();
	public boolean createAccount(String username, String password,
			String fullname) {
		Account account = new Account(username, password, fullname);
		return acctDao.registerAccount(account);

	}

	public boolean checkUsername(String username) {
		
		return acctDao.checkIfUserExist(username);
	}

}
