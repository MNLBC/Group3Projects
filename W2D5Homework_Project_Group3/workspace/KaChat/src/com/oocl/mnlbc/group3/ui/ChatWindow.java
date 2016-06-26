package com.oocl.mnlbc.group3.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.oocl.mnlbc.group3.model.Chat;
import com.oocl.mnlbc.group3.server.ChatClient;
import com.oocl.mnlbc.group3.transaction.RegistrationTransaction;

/**
 * 
 */

/**
 * @author VERGAJO
 *
 */
public class ChatWindow extends JFrame implements ActionListener, KeyListener {
	private JMenuBar menuBar;
	private String username;
	private ChatClient chatClient;
	private JButton btnSend;
	private JTextArea taChatBox;
	private JTextArea taChatMessages;
	private List<Chat> chat;
	private SimpleDateFormat sdf;
	private JMenuItem mntmSave;
	private JMenuItem mntmQuit;
	RegistrationTransaction regTxn;

	public ChatWindow(String username) {
		this.username = username;
		// ChatClient = new ChatClient();
		init();

		// initClient();

	}

	// public void initClient() {
	//
	// }

	public void init() {
		regTxn = new RegistrationTransaction();
		chat = new ArrayList<Chat>();
		sdf = new SimpleDateFormat("hh:mm:ssa MMM/dd/yyyy");
		setResizable(false);
		setTitle("KaChat");

		setBounds(100, 100, 500, 400);

		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		taChatMessages = new JTextArea();
		taChatMessages.setLineWrap(true);

		taChatBox = new JTextArea();
		taChatBox.setLineWrap(true);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JTextArea taUsers = new JTextArea();
		taUsers.setEnabled(false);
		taUsers.setEditable(false);
		taUsers.setBounds(366, 12, 118, 266);
		panel_1.add(taUsers);

		chatClient = new ChatClient(taChatMessages, taUsers, username);

		btnSend = new JButton("Send");
		btnSend.addActionListener(this);
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnSend, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
								.addComponent(btnSend, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
						.addContainerGap()));

		scrollPane_1.setViewportView(taChatBox);
		panel.setLayout(gl_panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 346, 267);
		panel_1.add(scrollPane);

		scrollPane.setViewportView(taChatMessages);

		// List<String> users = new ArrayList<String>();
		// users.add(username);
		// System.out.println(users);
		// for (String user : users)
		// taUsers.append(user + "\n");

		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);

		JMenu mnFile = new JMenu("File");
		menuBar_1.add(mnFile);

		mntmSave = new JMenuItem("Save Chat");
		mntmSave.addActionListener(this);
		mnFile.add(mntmSave);

		mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(this);
		mnFile.add(mntmQuit);
		StringBuffer allChat= new StringBuffer("");
		List<Chat> tempChat = regTxn.prevChat();
		
		for(Chat prev: tempChat ){
		
			allChat.append(prev.getUsername() + ": " + prev.getChat() + " - " + prev.getDate()+"\n");
		}
		taChatMessages.setText(allChat.toString());

	}

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// try {
	// for (javax.swing.UIManager.LookAndFeelInfo info :
	// javax.swing.UIManager.getInstalledLookAndFeels()) {
	// if ("Nimbus".equals(info.getName())) {
	// javax.swing.UIManager.setLookAndFeel(info.getClassName());
	// break;
	// }
	// }
	// } catch (ClassNotFoundException ex) {
	// java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE,
	// null,
	// ex);
	// } catch (InstantiationException ex) {
	// java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE,
	// null,
	// ex);
	// } catch (IllegalAccessException ex) {
	// java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE,
	// null,
	// ex);
	// } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	// java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE,
	// null,
	// ex);
	// }
	//
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// ChatWindow frame = new ChatWindow();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == btnSend) {
			if (!taChatBox.getText().equals("")) {

				Calendar calendar = new GregorianCalendar();
				System.out.println(sdf.format(calendar.getTime()));

				String message = taChatBox.getText() + "\n";

				chatClient.displayAll(username + ": " + message + " - " + sdf.format(calendar.getTime()));
				Chat sent = new Chat(username, message, sdf.format(calendar.getTime()));
				chat.add(sent);
				// taChatMessages.append(username + ": " +
				// taChatBox.getText() + "\n");
				// taChatMessages.append(username + ": " + message + "\n");
				regTxn.saveChat(sent);
				taChatBox.setText("");
				System.out.println("Message Sent");
			}

		} else if (obj == mntmQuit) {
			this.dispose();

		} else if (obj == mntmSave) {
			try {
				regTxn.logChat(chat);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
