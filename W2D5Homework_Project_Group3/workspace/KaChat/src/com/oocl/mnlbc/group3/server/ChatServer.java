package com.oocl.mnlbc.group3.server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.applet.*;

/**]
 * 
 * @author vergajo
 *
 */
public class ChatServer implements Runnable {

	private int port;
	private int backlog;
	private int numConnections = 0;
	private int maxConnections;
	private Vector connections = null;
	private List<String> users;
/**
 * Constructor of Chat Server
 */
	public ChatServer() {
		GetServerProperty server = new GetServerProperty();
		this.port = Integer.parseInt(server.getPort());
		this.maxConnections = Integer.parseInt(server.getMaxConnections());
		this.backlog = Integer.parseInt(server.getMaxBackLog());
		
		
	}
/**
 * Main of server
 * @param args
 */
	public static void main(String[] args) {
		ChatServer cs = new ChatServer();
		cs.go();
	}
/**
 * runs the thread for receiving connections
 */
	public void go() {
		this.connections = new Vector(maxConnections);
		Thread t = new Thread(this);
		t.start();
	}
/**
 * Runnable - Thread
 */
	public void run() {
		ServerSocket serverSocket = null;
		Socket communicationSocket;

		try {
			System.out.println("Attempting to start server...");
			serverSocket = new ServerSocket(port, backlog);
		} catch (IOException e) {
			System.out.println("Error starting server: Could not open port " + port);
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println("Started server on port " + port);

		// Run the listen/accept loop forever
		while (true) {
			try {
				// Wait here and listen for a connection
				communicationSocket = serverSocket.accept();
				HandleConnection(communicationSocket);
			} catch (Exception e) {
				System.out.println("Unable to spawn child socket.");
				e.printStackTrace();
			}
		}
	}
/**
 * 
 * @param connection
 */
	public void HandleConnection(Socket connection) {
		synchronized (this) {
			while (numConnections == maxConnections) {
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		numConnections++;
		Connection con = new Connection(connection);
		Thread t = new Thread(con);
		t.start();
		connections.addElement(con);
	}
/**
 * 
 * @param connection
 */
	public synchronized void connectionClosed(Connection connection) {
		connections.removeElement(connection);
		numConnections--;
		notify();
	}
/**
 * 
 * @param message
 */
	public void sendToAllClients(String message) {
		Enumeration cons = connections.elements();
		while (cons.hasMoreElements()) {
			Connection c = (Connection) cons.nextElement();
			c.sendMessage(message);
		}
	}

	/**
	 * 
	 * inner class for receiving connection thread
	 *
	 */
	class Connection implements Runnable {

		private Socket communicationSocket = null;
		private OutputStreamWriter out = null;
		private BufferedReader in = null;

		public void run() {
			OutputStream socketOutput = null;
			InputStream socketInput = null;

			try {
				socketOutput = communicationSocket.getOutputStream();
				out = new OutputStreamWriter(socketOutput);
				socketInput = communicationSocket.getInputStream();
				in = new BufferedReader(new InputStreamReader(socketInput));
				String input = null;
				String message = "";
				String user="";
				while ((input = in.readLine()) != null) {
					ChatServer.this.sendToAllClients(input + "\n");

			}

			} catch (Exception e) {
			} finally {
				try {
					if (in != null)
						in.close();
					if (out != null)
						out.close();
					communicationSocket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ChatServer.this.connectionClosed(this);
			}
		}
/**
 * 
 * @param s
 */
		public Connection(Socket s) {
			communicationSocket = s;
		}
/**
 * 
 * @param message
 */
		public void sendMessage(String message) {
			try {
				out.write(message);
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}