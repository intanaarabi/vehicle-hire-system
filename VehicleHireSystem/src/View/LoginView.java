package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.LoginController;

public class LoginView extends View{
	
	private JLabel usernameLabel;
	private JTextField usernameText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JButton staffButton, custButton;
	private JLabel loginSuccess;
	private LoginController controller;
	
	
	public LoginView(LoginController controller) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login");
	    this.controller = controller;


	    panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));
	    panel.setLayout(new GridLayout(0,1));

		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(10, 20, 80, 25);
		panel.add(usernameLabel);
		
		usernameText = new JTextField(20);
		usernameText.setBounds(100, 20, 165, 25);
		panel.add(usernameText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		staffButton = new JButton("Login Staff");
		staffButton.setBounds(10, 80, 80, 25);
		staffButton.addActionListener(this.controller);
		panel.add(staffButton);
		
		custButton = new JButton("Login Customer");
		custButton.setBounds(10, 80, 80, 25);
		custButton.addActionListener(this.controller);
		
		panel.add(custButton);
		
		loginSuccess = new JLabel("");
		loginSuccess.setBounds(10, 110, 300, 25);
		panel.add(loginSuccess);
		
		this.panel = panel;
		this.frame = frame;
		
	    frame.add(this.getPanel(), BorderLayout.CENTER);
		this.frame.pack();
		this.frame.setVisible(true);
	
	    controller.addView(this);
	}
	
	public String getUsername() {
		return this.usernameText.getText();
	}
	
	public String getPassword() {
		return this.passwordText.getText();
	}
	
	public JButton getStaffButton() {
		return this.staffButton;
	}
	
	public JButton getCustButton() {
		return this.custButton;
	}
	
	
	

	
	public void setSuccessText() {
		this.loginSuccess.setText("Login Successful");
	}
	
	public void setFailText() {
		this.loginSuccess.setText("Login Failed");
	}
	



}
