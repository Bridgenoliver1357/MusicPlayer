package musicPlayer.frontEnd.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import musicPlayer.backEnd.database.Database;
import musicPlayer.backEnd.security.Hashing;
import musicPlayer.frontEnd.FrameController;

public class SecureChangePanelButton extends ChangePanelButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 376650053582697966L;
	
	private JTextField username;
	private JPasswordField password;
	private Database db;

	public SecureChangePanelButton(int panelID, JTextField username, JPasswordField password,  Database db) {
		super(panelID);
		this.username = username;
		this.password = password;
		this.db = db;
	}

	public SecureChangePanelButton(Icon icon, int panelID, JTextField username, JPasswordField password, Database db) {
		super(icon, panelID);
		this.username = username;
		this.password = password;
		this.db = db;
	}

	public SecureChangePanelButton(String text, int panelID, JTextField username, JPasswordField password, Database db) {
		super(text, panelID);
		this.username = username;
		this.password = password;
		this.db = db;
	}

	public SecureChangePanelButton(Action a, int panelID, JTextField username, JPasswordField password, Database db) {
		super(a, panelID);
		this.username = username;
		this.password = password;
		this.db = db;
	}

	public SecureChangePanelButton(String text, Icon icon, int panelID, JTextField username, JPasswordField password, Database db) {
		super(text, icon, panelID);
		this.username = username;
		this.password = password;
		this.db = db;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		byte[] hash;
		try {
			hash = Hashing.getHashWithSalt(new String(password.getPassword()), db.getSalt(db.getID(username.getText())));
			
			if(Arrays.equals(db.getPassword(db.getID(username.getText())), hash)) {
				FrameController.changePanel(super.panelID);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
	}

}
