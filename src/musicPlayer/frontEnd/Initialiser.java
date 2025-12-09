package musicPlayer.frontEnd;

import musicPlayer.backEnd.database.Database;

import java.sql.SQLException;

public class Initialiser{
	private static final int DEFAULT_PANEL_ID = 0;

	public Initialiser() throws SQLException {
		
		Database db = new Database();
		db.addCredentialsTable();
		db.close();
		
		FrameController.initialiseFrame();
		
		FrameController.changePanel(DEFAULT_PANEL_ID);

	}

}
