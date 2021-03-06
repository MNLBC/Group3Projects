package com.oocl.mnlbc.group3.transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.oocl.mnlbc.group3.dao.AccountDAOImpl;
import com.oocl.mnlbc.group3.model.Account;
import com.oocl.mnlbc.group3.model.Chat;
/**
 * 
 * @author yume
 * Transaction methods in KaChat
 */
public class ChatTransaction {
	
	AccountDAOImpl acctDao = AccountDAOImpl.getInstance();
	List<Chat> chatFile = new ArrayList<Chat>();
	SimpleDateFormat sdf;

	public boolean createAccount(String username, String password, String fullname) {
		Account account = new Account(username, password, fullname);
		return acctDao.registerAccount(account);
	}

	public void saveChat(Chat chat) {

		acctDao.saveChatHistory(chat);

	}

	public boolean checkUsername(String username) {

		return acctDao.checkIfUserExist(username);
	}

	public boolean validate(String user, String password) {

		return acctDao.validateAccount(user, password);
	}

	public List<Chat> prevChat() {

		return acctDao.getPreviousChat();
	}

	public void logChat(List<Chat> chat) throws IOException {
		sdf = new SimpleDateFormat("hhmmssaMMMddyyyy");
		Calendar calendar = new GregorianCalendar();
		System.out.println(sdf.format(calendar.getTime()));
		File file = new File("D:\\history\\logChat" + sdf.format(calendar.getTime()) + ".html");
		file.getParentFile().mkdirs();
		file.createNewFile();
		FileWriter writer = new FileWriter(file);

		writer.append("<html>" + "\n");
		writer.append("<head>" + "\n");
		writer.append("<title>kaChat History</title>" + "\n");
		writer.append("</head>" + "\n");

		writer.append("<body>" + "\n");
		for (Chat chatSave : chat) {
			System.out.println(chatSave.getUsername());
			writer.append("<h2> <b>" + chatSave.getUsername() + "</h2></b>: <p>" + chatSave.getChat() + " "
					+ chatSave.getDate() + "</p><br>" + "\n");
		}
		writer.append("</body>" + "\n");
		writer.append("</html>" + "\n");
		writer.flush();
		writer.close();
	}

}
