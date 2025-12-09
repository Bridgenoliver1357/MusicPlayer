package musicPlayer.frontEnd.panels;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import musicPlayer.frontEnd.FrameController;
import musicPlayer.frontEnd.components.ChangePanelButton;

public class SignUpPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4808942092016073571L;
	
	public static final int PANEL_ID = 1;
	
	private JLabel titleLabel;
	private JButton btnNewButton;

	public SignUpPanel() {
		
		setBounds(FrameController.DEFAULT_PANEL_BOUNDS);
		setLayout(null);
		
		titleLabel = new JLabel("Music Player");
		btnNewButton = new ChangePanelButton("Login", LoginPanel.PANEL_ID);
		
		setUpGUI();
	}
	
	private void setUpGUI() {
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 52));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(10, 24, 705, 141);
		add(titleLabel);
		
		btnNewButton.setBounds(154, 427, 89, 23);
		add(btnNewButton);
		
		setVisible(true);
	}
}
