package musicPlayer.frontEnd.panels;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.SQLException;

import musicPlayer.backEnd.database.Database;
import musicPlayer.frontEnd.FrameController;
import musicPlayer.frontEnd.components.*;
import musicPlayer.frontEnd.components.ShowPasswordButton;

import javax.swing.JToggleButton;

public class LoginPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public static final int PANEL_ID = 0;
	
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel titleLabel;
	private JLabel messageLabel;
	private ChangePanelButton loginButton;
	private ChangePanelButton signUpButton;
	
	
	private JToggleButton showPasswordButton;
	
	private Database db;

	public LoginPanel() {
		
		
		setBounds(FrameController.DEFAULT_PANEL_BOUNDS);
		setLayout(null);
		
		
		
		usernameText = new JTextField();
		passwordText = new JPasswordField();
		usernameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		titleLabel = new JLabel("Music Player");
		messageLabel = new JLabel();
		loginButton = new SecureChangePanelButton("Login", SignUpPanel.PANEL_ID, usernameText, passwordText, db);
		signUpButton = new ChangePanelButton("Sign Up", SignUpPanel.PANEL_ID);
		showPasswordButton = new ShowPasswordButton(passwordText);
		
		try {
			db = new Database();
		} catch (SQLException e) {
			messageLabel.setText("Database connection failed");
		}
		
		setUpGUI();
		
	}
	
	private void setUpGUI() {
		
		usernameText.setBounds(137, 230, 500, 44);
		usernameText.setColumns(10);
		add(usernameText);
		
		passwordText.setColumns(10);
		passwordText.setBounds(137, 285, 457, 44);
		passwordText.setEchoChar('*');
		add(passwordText);
		
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(10, 230, 86, 44);
		add(usernameLabel);
		
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(10, 285, 86, 44);
		add(passwordLabel);
		
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 52));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(10, 24, 705, 141);
		add(titleLabel);
		
		messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 52));
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setBounds(137, 182, 500, 37);
		add(messageLabel);
		
		loginButton.setBounds(449, 385, 162, 44);
		add(loginButton);
		
		signUpButton.setBounds(264, 385, 162, 44);
		
		add(signUpButton);
		
		showPasswordButton.setBounds(594, 285, 43, 44);
		add(showPasswordButton);
		
		setVisible(true);

	}
}
