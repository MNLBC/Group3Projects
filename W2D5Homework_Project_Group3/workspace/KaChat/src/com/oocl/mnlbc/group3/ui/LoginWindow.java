package com.oocl.mnlbc.group3.ui;

/**
 * 
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.oocl.mnlbc.group3.dao.AccountDAOImpl;
import com.oocl.mnlbc.group3.transaction.ChatTransaction;

/**
 * Login window for KaChat Validates the username and password
 * 
 * @author BES
 * @version 1.0
 */
public class LoginWindow extends JFrame implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelMain;
	private JLabel lblUsername;
	private JTextField textUsername;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnExit;
	private short loginCounter;
	private JButton btnRegister;
	
	ChatTransaction regTxn;

	/**
	 * Create the frame.
	 * 
	 */
	public LoginWindow() {
		regTxn = new ChatTransaction();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// sets the size
		setBounds(100, 100, 450, 253);

		// center starting position
		setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Login to KaChat");

		// instantiate the content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);

		panelMain = new JPanel();
		panelMain.setBorder(BorderFactory.createTitledBorder(null, "Login", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 14)));

		contentPane.add(panelMain, BorderLayout.CENTER);

		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", 1, 12));

		textUsername = new JTextField();
		textUsername.setColumns(10);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", 1, 12));
		passwordField = new JPasswordField();

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", 1, 12));

		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", 1, 12));
		btnExit.setFont(new Font("Tahoma", 1, 12));

		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));

		GroupLayout gl_panelMain = new GroupLayout(panelMain);
		gl_panelMain
				.setHorizontalGroup(gl_panelMain.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelMain.createSequentialGroup().addGap(35).addGroup(gl_panelMain
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelMain.createSequentialGroup().addGap(21)
										.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 103,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
										.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 103,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE).addComponent(
												btnExit, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
								.addGroup(
										gl_panelMain.createSequentialGroup()
												.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
														.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 78,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPassword))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
														.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 281,
																Short.MAX_VALUE)
														.addComponent(textUsername, GroupLayout.DEFAULT_SIZE, 281,
																Short.MAX_VALUE))))
								.addGap(24)));
		gl_panelMain.setVerticalGroup(gl_panelMain.createParallelGroup(Alignment.LEADING).addGroup(gl_panelMain
				.createSequentialGroup().addGap(38)
				.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING).addGroup(gl_panelMain
						.createSequentialGroup().addGap(92)
						.addGroup(gl_panelMain.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(20, Short.MAX_VALUE))
						.addGroup(gl_panelMain.createSequentialGroup()
								.addGroup(gl_panelMain.createParallelGroup(Alignment.BASELINE).addComponent(lblUsername)
										.addComponent(textUsername, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panelMain.createParallelGroup(Alignment.BASELINE).addComponent(lblPassword)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
								.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addGap(23)))));
		panelMain.setLayout(gl_panelMain);
		passwordField.addKeyListener(this);
		loginCounter = 0;
		btnExit.addActionListener(this);
		btnLogin.addActionListener(this);
		btnRegister.addActionListener(this);
	}

	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Validates user credentials
	 */
	public void login() {

		String username = textUsername.getText();
		char[] pass = passwordField.getPassword();
		String password = getPassword(pass);
		if (username.equals("")) {
			JOptionPane.showMessageDialog(this, "Username is blank.");
		} else if (password.equals("")) {
			JOptionPane.showMessageDialog(this, "Password is blank.");
		} else {
			if (regTxn.validate(username, password)) {
				JOptionPane.showMessageDialog(this, "Successfuly Logged in!");
				
				Main main = new Main(username);
				main.setVisible(true);
				this.dispose();

				/*
				 * Proceed to Main Chat window this.setEnabled(false);
				 */
			} else {
				JOptionPane.showMessageDialog(this, "Invalid credentials!");
				passwordField.setText("");
				loginCounter += 1;
				if (loginCounter == 3) {
					System.exit(0);
				}
			}
		}
	}



	/**
	 * 
	 * @param pass
	 * @return
	 */
	public String getPassword(char[] pass) {
		String inputPass = "";
		for (char ch : pass) {
			inputPass += String.valueOf(ch);
		}
		return inputPass;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int inp = e.getKeyCode();
		if (inp == 10) {
			this.login();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == btnExit) {
			System.out.println("Exit");
			this.dispose();
		} 
		else if (obj == btnLogin) {
			this.login();
		} 
		else if (obj == btnRegister){
			RegistrationWindow regFrame = new RegistrationWindow();
			regFrame.setVisible(true);
			this.dispose();
		}
	}
}
