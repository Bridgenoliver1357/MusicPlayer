package musicPlayer;

import java.awt.EventQueue;
import java.sql.SQLException;

import musicPlayer.frontEnd.Initialiser;

public class Main{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Initialiser();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
}
