package com.oocl.mnlbc.group3.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class RegistrationWindow extends JFrame implements ActionListener, KeyListener {

	private JFrame frame;
	private JTextField txtFullname;
	private JLabel lblFullname;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblConfirm;
	private JTextField txtPassword;
	private JTextField txtConfirm;
	private JTextField txtUsername;
	private JButton btnClear;
	private JButton btnSave;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
//					.getInstalledLookAndFeels()) {
//				if ("Nimbus".equals(info.getName())) {
//					javax.swing.UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//		} catch (ClassNotFoundException ex) {
//			java.util.logging.Logger.getLogger(
//					RegistrationWindow.class.getName()).log(
//					java.util.logging.Level.SEVERE, null, ex);
//		} catch (InstantiationException ex) {
//			java.util.logging.Logger.getLogger(
//					RegistrationWindow.class.getName()).log(
//					java.util.logging.Level.SEVERE, null, ex);
//		} catch (IllegalAccessException ex) {
//			java.util.logging.Logger.getLogger(
//					RegistrationWindow.class.getName()).log(
//					java.util.logging.Level.SEVERE, null, ex);
//		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
//			java.util.logging.Logger.getLogger(
//					RegistrationWindow.class.getName()).log(
//					java.util.logging.Level.SEVERE, null, ex);
//		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					this.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public RegistrationWindow() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblRegister = new JLabel("Registration");
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup().addGap(164)
						.addComponent(lblRegister)
						.addContainerGap(212, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addComponent(lblRegister)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		this.getContentPane().add(panel_1, BorderLayout.CENTER);

		txtFullname = new JTextField();
		txtFullname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtFullname.setColumns(10);

		lblFullname = new JLabel("Full Name: ");
		lblFullname.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblPassword = new JLabel(" Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblConfirm = new JLabel(" Confirm Password: ");
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setColumns(10);

		txtConfirm = new JPasswordField();
		txtConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtConfirm.setColumns(10);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setColumns(10);

		btnClear = new JButton("Clear");

		btnSave = new JButton("Save");

		btnBack = new JButton("Back");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(39)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addGroup(
																												gl_panel_1
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addComponent(
																																lblUsername,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																lblFullname,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																lblPassword,
																																GroupLayout.PREFERRED_SIZE,
																																94,
																																GroupLayout.PREFERRED_SIZE))
																										.addGap(14))
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addComponent(
																												btnClear,
																												GroupLayout.PREFERRED_SIZE,
																												116,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(27))))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblConfirm)))
										.addGap(14)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(10)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								txtPassword)
																						.addComponent(
																								txtFullname,
																								GroupLayout.DEFAULT_SIZE,
																								183,
																								Short.MAX_VALUE)
																						.addComponent(
																								txtUsername,
																								GroupLayout.DEFAULT_SIZE,
																								183,
																								Short.MAX_VALUE)
																						.addComponent(
																								txtConfirm)))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnSave,
																				GroupLayout.PREFERRED_SIZE,
																				116,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(28)
																		.addComponent(
																				btnBack,
																				GroupLayout.PREFERRED_SIZE,
																				116,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(42)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(36)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblFullname,
																GroupLayout.PREFERRED_SIZE,
																27,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtFullname,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(11)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblUsername)
														.addComponent(
																txtUsername,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(18)
																		.addComponent(
																				lblPassword))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				txtPassword,
																				GroupLayout.PREFERRED_SIZE,
																				25,
																				GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblConfirm)
														.addComponent(
																txtConfirm,
																GroupLayout.PREFERRED_SIZE,
																25,
																GroupLayout.PREFERRED_SIZE))
										.addGap(55)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				btnClear,
																				GroupLayout.PREFERRED_SIZE,
																				38,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				btnSave,
																				GroupLayout.PREFERRED_SIZE,
																				38,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																btnBack,
																GroupLayout.PREFERRED_SIZE,
																38,
																GroupLayout.PREFERRED_SIZE))
										.addGap(85)));
		panel_1.setLayout(gl_panel_1);

		btnClear.addActionListener(this);
		btnSave.addActionListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == btnClear) {
			clearFields();
		} else if (obj == btnSave) {
			validateFields();
		}

	}

	private void clearFields() {
		// TODO Auto-generated method stub
		txtFullname.setText("");
		txtPassword.setText("");
		txtUsername.setText("");
		txtConfirm.setText("");

	}

	public void validateFields() {
		boolean fieldsValid = fieldsValid();
		if (fieldsValid) {
			if(passwordsMatch()){
				System.out.println("valid credentials");
			}else{
				JOptionPane.showMessageDialog(txtConfirm, "Passwords do not match.");
			}
			
		}
	}

	public boolean fieldsValid() {
		boolean fieldsValid = true;
		if (txtFullname.getText().equals("")) {
			fieldsValid = false;
			JOptionPane.showMessageDialog(txtFullname, "Fullname is blank.");

		} else if (txtPassword.getText().equals("")) {
			fieldsValid = false;
			JOptionPane.showMessageDialog(txtPassword, "Password is blank.");

		} else if (txtUsername.getText().equals("")) {
			fieldsValid = false;
			JOptionPane.showMessageDialog(txtFullname, "Username is blank.");

		
		}
		return fieldsValid;
	}

	public boolean passwordsMatch() {

		return txtPassword.getText().equals(txtConfirm.getText());
	}
}
