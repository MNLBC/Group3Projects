package com.oocl.mnlbc.group3.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame implements ActionListener, KeyListener{

	private JFrame frame;
	private JButton btnConnect;
	private JButton btnLogout ;
	private JButton btnExit;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main window = new Main();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 500, 400);;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("");
		
		JLabel lblKachat = new JLabel("   kaChat Main Page");
		lblKachat.setVerticalAlignment(SwingConstants.BOTTOM);
		lblKachat.setToolTipText("");
		lblKachat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		 btnConnect = new JButton("Connect to Group Chat");
		 btnLogout = new JButton("Logout");
		 btnExit = new JButton("Exit");
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(169)
					.addComponent(label))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(160)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnLogout, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
							.addComponent(btnConnect, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(136)
					.addComponent(lblKachat, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(lblKachat, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label)
					.addGap(18)
					.addComponent(btnConnect, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		this.getContentPane().setLayout(groupLayout);
		btnLogout.addActionListener(this);
		btnConnect.addActionListener(this);
		btnExit.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object obj = arg0.getSource();
		if(obj==btnLogout ){
			LoginWindow login = new LoginWindow();
			login.setVisible(true);
			this.dispose();
		}else if(obj==btnConnect){
			ChatWindow chat = new ChatWindow();
			chat.setVisible(true);
			this.dispose();
			
		}else if(obj==btnExit){
			System.exit(0);
		}
		
	}
	
	

}
