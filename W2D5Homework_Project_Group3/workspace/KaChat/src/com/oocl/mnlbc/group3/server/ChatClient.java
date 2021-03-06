/**
 * 
 */
package com.oocl.mnlbc.group3.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * @author yume
 *
 */
public class ChatClient {
	private final String DEFAULT_SERVER_IP = "127.0.0.1";
	private final int DEFAULT_SERVER_PORT = 5555;

	private String serverIP = DEFAULT_SERVER_IP;
	private int serverPort = DEFAULT_SERVER_PORT;

	private Socket connection = null;
	private BufferedReader serverIn = null;
	private PrintStream serverOut = null;

	private JTextArea taChatMessages;
	private JTextArea txtAreaUsers;
	private String username;
	private List<String> users = new ArrayList<String>();

	//
	// public static void main(String args[]) {
	// ChatClient chatClient = new ChatClient();
	//
	// }
	/**
	 * 
	 * @param txtAreaChat
	 * @param txtAreaUsers
	 * @param username
	 */
	public ChatClient(JTextArea txtAreaChat, JTextArea txtAreaUsers, String username) {
		this.taChatMessages = txtAreaChat;
		this.txtAreaUsers = txtAreaUsers;
		this.username = username;

		users.add(username);
		System.out.println(users);
		for (String user : users)
			txtAreaUsers.append(user + "\n");

		String serverIP = System.getProperty("serverip");
		if (serverIP != null) {
			this.serverIP = serverIP;
		}
		String serverPort = System.getProperty("serverport");
		if (serverPort != null) {
			this.serverPort = Integer.parseInt(serverPort);
		}

		try {
			connection = new Socket(serverIP, this.serverPort);
			serverIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			serverOut = new PrintStream(connection.getOutputStream());

			// System.out.println(serverIn.readLine());
			Thread t = new Thread(new RemoteReader());
			t.start();
		} catch (Exception e) {
			System.out.println("Unable to connect to Server");
			e.printStackTrace();

		}
	}

	/**
	 * 
	 * inner class for thread running the Input Listener for the messages sent
	 * by the server
	 *
	 */
	private class RemoteReader implements Runnable {
		private boolean keepListening = true;
		String message;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (keepListening == true) {
				try {
					String nextLine = serverIn.readLine();
					if (!nextLine.equals("")) {
						taChatMessages.append(nextLine + "\n");
					}
				} catch (Exception e) {
					keepListening = false;
					System.out.println("Error while reading from server.");
					e.printStackTrace();
				}
			}
		}
	
		}

	}

	/**
	 * 
	 * @return BufferedReader
	 */
	public BufferedReader getServerIn() {
		return this.serverIn;
	}

	/**
	 * 
	 * @param message
	 */
	public void sendMessage(String message) {
		serverOut.println(message);
	}

	/**
	 * 
	 * @return PrintStream
	 */
	public PrintStream getServerOut() {
		return this.serverOut;
	}
}
