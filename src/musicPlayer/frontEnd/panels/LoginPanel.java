package musicPlayer.frontEnd.panels;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import musicPlayer.frontEnd.PanelController;
import musicPlayer.frontEnd.components.ChangePanelButton;
import musicPlayer.frontEnd.components.ShowPasswordButton;

import javax.swing.JToggleButton;

public class LoginPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public static final int PANEL_ID = 0;
	
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private ChangePanelButton loginButton;
	private ChangePanelButton signUpButton;
	private JLabel titleLabel;
	
//	private PanelIndex controller;
	private JToggleButton showPasswordButton;

	public LoginPanel(PanelController controller) {
		
//		this.controller = controller;
		
		setBounds(PanelController.DEFAULT_PANEL_BOUNDS);
		setLayout(null);
		
		
		
		usernameText = new JTextField();
		passwordText = new JPasswordField();
		usernameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		loginButton = new ChangePanelButton("Login", controller, SignUpPanel.PANEL_ID);
		signUpButton = new ChangePanelButton("Sign Up", controller, SignUpPanel.PANEL_ID);
		titleLabel = new JLabel("Music Player");
		showPasswordButton = new ShowPasswordButton(passwordText);
		
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
		
		loginButton.setBounds(449, 385, 162, 44);
		add(loginButton);
		
		signUpButton.setBounds(264, 385, 162, 44);
		
		add(signUpButton);
		
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 52));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(10, 24, 705, 141);
		add(titleLabel);
		
		showPasswordButton.setBounds(594, 285, 43, 44);
		add(showPasswordButton);
		
		setVisible(true);

	}
}
