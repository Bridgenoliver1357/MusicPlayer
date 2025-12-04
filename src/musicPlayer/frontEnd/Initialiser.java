package musicPlayer.frontEnd;

import javax.swing.JFrame;

import musicPlayer.backEnd.database.Database;

import java.awt.Rectangle;
import java.sql.SQLException;

public class Initialiser{
	private PanelController controller;
	private static final int DEFAULT_PANEL_ID = 0;
	private static Rectangle FRAME_BOUNDS = new Rectangle(100, 100, 725, 500);
	private JFrame frame;
	private Database db;

	public Initialiser() throws SQLException {
		
		db = new Database();
		setUpDatabase();
		
		frame = new JFrame();
		setUpFrame();
		
		controller = new PanelController(frame);
		
		start();
	}
	
	private void setUpFrame() {
		frame.setResizable(false);
		frame.setBounds(FRAME_BOUNDS);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setUpDatabase() throws SQLException {
		db.addCredentialsTable();
	}
	
	private void start() {
		controller.changePanel(DEFAULT_PANEL_ID);
	}

}
