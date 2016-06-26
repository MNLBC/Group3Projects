package com.oocl.mnlbc.group3.transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.oocl.mnlbc.group3.dao.AccountDAOImpl;
import com.oocl.mnlbc.group3.model.Account;
import com.oocl.mnlbc.group3.model.Chat;
import com.oocl.mnlbc.group3.model.Conversation;

public class RegistrationTransaction {
	AccountDAOImpl acctDao = AccountDAOImpl.getInstance();

	static List<Chat> chatFile = new ArrayList<Chat>();

	public static void init() {
		chatFile.add(new Chat("kanench", "this is a message", "6/26/2016"));
		chatFile.add(new Chat("cuntaal", "message it is", "6/26/2016"));
		chatFile.add(new Chat("floreje", "test", "6/26/2016"));

	}

	public boolean createAccount(String username, String password,
			String fullname) {
		Account account = new Account(username, password, fullname);
		return acctDao.registerAccount(account);

	}

	public boolean checkUsername(String username) {

		return acctDao.checkIfUserExist(username);
	}

	public boolean validate(String user, String password) {

		return acctDao.validateAccount(user, password);
	}

	public static void logChat() throws IOException {

		File file = new File("D:\\history\\logChat.hmtl");
		file.getParentFile().mkdirs();
		file.createNewFile();
		FileWriter writer = new FileWriter(file);

		writer.append("<html>" + "\n");
		writer.append("<head>" + "\n");
		writer.append("<title>kaChat History</title>" + "\n");
		writer.append("</head>" + "\n");

		writer.append("<body>" + "\n");
		for (Chat chatSave : chatFile) {
			System.out.println(chatSave.getUsername());
			writer.append("<p>" + chatSave.getUsername() + ": "
					+ chatSave.getChat() + " " + chatSave.getDate() + "<br>"
					+ "\n");
		}
		writer.append("</body>" + "\n");
		writer.append("</html>" + "\n");
		writer.flush();
		writer.close();
	}

	public static void main(String args[]) throws IOException {
		init();
		logChat();

	}

}
