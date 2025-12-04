package musicPlayer.frontEnd;

import javax.swing.JFrame;

import musicPlayer.frontEnd.panels.LoginPanel;
import musicPlayer.frontEnd.panels.ResetPasswordPanel;
import musicPlayer.frontEnd.panels.SignUpPanel;

import java.awt.Rectangle;

public class PanelController{
	
	private JFrame frame;
	public static Rectangle DEFAULT_PANEL_BOUNDS = new Rectangle(0, 0, 725, 500);

	public PanelController(JFrame frame) {
		this.frame = frame;
	}
	
	public void changePanel(int panelId) {
		switch(panelId) {
		case 0:
			frame.getContentPane().removeAll();
			frame.revalidate();
			frame.getContentPane().add(new LoginPanel(this));
			frame.setVisible(true);
			break;
		case 1:
			frame.getContentPane().removeAll();
			frame.revalidate();
			frame.getContentPane().add(new SignUpPanel(this));
			frame.setVisible(true);
			break;
		case 2:
			frame.getContentPane().removeAll();
			frame.revalidate();
			frame.getContentPane().add(new ResetPasswordPanel(this));
			frame.setVisible(true);
			break;
		}
	}

}
