package musicPlayer.frontEnd.components;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;

public class ShowPasswordButton extends JToggleButton implements ItemListener{
	
	//Extension of the toggle button class to make a show password button which includes a listener by default and the icons for selected and deselected. 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 336119761224209211L;
	private JPasswordField passwordField;
	private final ImageIcon showPassword = new ImageIcon(ShowPasswordButton.class.getResource("/musicPlayer/frontEnd/panels/Icons/hidePasswordIcon.jpg"));
	private final ImageIcon hidePassword = new ImageIcon(ShowPasswordButton.class.getResource("/musicPlayer/frontEnd/panels/Icons/showPasswordIcon.jpg"));
	
	public ShowPasswordButton(JPasswordField passwordField) {
		this.passwordField = passwordField;
		setIcon(showPassword);
		setSelectedIcon(hidePassword);
		addItemListener(this);
	}

	public ShowPasswordButton(Icon icon, JPasswordField passwordField) {
		super(icon);
		this.passwordField = passwordField;
		setIcon(showPassword);
		setSelectedIcon(hidePassword);
		addItemListener(this);
	}

	public ShowPasswordButton(String text, JPasswordField passwordField) {
		super(text);
		this.passwordField = passwordField;
		setIcon(showPassword);
		setSelectedIcon(hidePassword);
		addItemListener(this);
	}

	public ShowPasswordButton(Action a, JPasswordField passwordField) {
		super(a);
		this.passwordField = passwordField;
		setIcon(showPassword);
		setSelectedIcon(hidePassword);
		addItemListener(this);
	}

	public ShowPasswordButton(Icon icon, boolean selected, JPasswordField passwordField) {
		super(icon, selected);
		this.passwordField = passwordField;
		setIcon(showPassword);
		setSelectedIcon(hidePassword);
		addItemListener(this);
	}

	public ShowPasswordButton(String text, boolean selected, JPasswordField passwordField) {
		super(text, selected);
		this.passwordField = passwordField;
		setIcon(showPassword);
		setSelectedIcon(hidePassword);
		addItemListener(this);
	}

	public ShowPasswordButton(String text, Icon icon, JPasswordField passwordField) {
		super(text, icon);
		this.passwordField = passwordField;
		setIcon(showPassword);
		setSelectedIcon(hidePassword);
		addItemListener(this);
	}

	public ShowPasswordButton(String text, Icon icon, boolean selected, JPasswordField passwordField) {
		super(text, icon, selected);
		this.passwordField = passwordField;
		setIcon(showPassword);
		setSelectedIcon(hidePassword);
		addItemListener(this);
	}

	
	@Override
	public void itemStateChanged(ItemEvent e) {
		int state = e.getStateChange();
		
		switch (state) {
		
		case ItemEvent.SELECTED:
			passwordField.setEchoChar((char) 0);
			break;
		case ItemEvent.DESELECTED:
			passwordField.setEchoChar('*');
			break;
		}
		
	}
	

}
