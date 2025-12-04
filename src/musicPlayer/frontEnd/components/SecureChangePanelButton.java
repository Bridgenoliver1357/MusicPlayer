package musicPlayer.frontEnd.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;

import musicPlayer.backEnd.database.Database;
import musicPlayer.frontEnd.PanelController;

public class SecureChangePanelButton extends ChangePanelButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 376650053582697966L;

	public SecureChangePanelButton(PanelController controller, int panelID) {
		super(controller, panelID);
	}

	public SecureChangePanelButton(Icon icon, PanelController controller, int panelID) {
		super(icon, controller, panelID);
	}

	public SecureChangePanelButton(String text, PanelController controller, int panelID) {
		super(text, controller, panelID);
	}

	public SecureChangePanelButton(Action a, PanelController controller, int panelID) {
		super(a, controller, panelID);
	}

	public SecureChangePanelButton(String text, Icon icon, PanelController controller, int panelID) {
		super(text, icon, controller, panelID);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.controller.changePanel(super.panelID);
	}

}
