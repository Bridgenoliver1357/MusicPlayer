package musicPlayer.frontEnd.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

import musicPlayer.frontEnd.FrameController;

public class ChangePanelButton extends JButton implements ActionListener{

	private static final long serialVersionUID = -8239458504502982023L;
	
//	protected FrameController controller;
	protected int panelID;

	public ChangePanelButton(int panelID) {
		super();
		this.panelID = panelID;
//		this.controller = controller;
		setFocusable(false);
		addActionListener(this);
	}

	public ChangePanelButton(Icon icon, int panelID) {
		super(icon);
		this.panelID = panelID;
//		this.controller = controller;
		setFocusable(false);
		addActionListener(this);
	}

	public ChangePanelButton(String text, int panelID) {
		super(text);
		this.panelID = panelID;
//		this.controller = controller;
		setFocusable(false);
		addActionListener(this);
	}

	public ChangePanelButton(Action a, int panelID) {
		super(a);
		this.panelID = panelID;
//		this.controller = controller;
		setFocusable(false);
		addActionListener(this);
	}

	public ChangePanelButton(String text, Icon icon, int panelID) {
		super(text, icon);
		this.panelID = panelID;
//		this.controller = controller;
		setFocusable(false);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FrameController.changePanel(panelID);
		
	}

}
