package musicPlayer.frontEnd;

import javax.swing.JFrame;

import musicPlayer.frontEnd.panels.LoginPanel;
import musicPlayer.frontEnd.panels.ResetPasswordPanel;
import musicPlayer.frontEnd.panels.SignUpPanel;

import java.awt.Rectangle;

public class FrameController{
	
	public static Rectangle DEFAULT_PANEL_BOUNDS = new Rectangle(0, 0, 725, 500);
	public static Rectangle FRAME_BOUNDS = new Rectangle(100, 100, 725, 500); 
	
	private static JFrame frame;
	
	public static void changePanel(int panelId) {
		switch(panelId) {
		case 0:
			frame.getContentPane().removeAll();
			frame.revalidate();
			frame.getContentPane().add(new LoginPanel());
			frame.setVisible(true);
			break;
		case 1:
			frame.getContentPane().removeAll();
			frame.revalidate();
			frame.getContentPane().add(new SignUpPanel());
			frame.setVisible(true);
			break;
		case 2:
			frame.getContentPane().removeAll();
			frame.revalidate();
			frame.getContentPane().add(new ResetPasswordPanel());
			frame.setVisible(true);
			break;
		}
	}
	
	public static void initialiseFrame() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(FRAME_BOUNDS);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
