package musicPlayer.backEnd.database;

import java.sql.*;

public class Database {
	
	private final String DATABASE_ADDRESS = "jdbc:sqlite:MusicDatabase.db";
	
	private static Connection conn;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	public Database() throws SQLException{
		conn = DriverManager.getConnection(this.DATABASE_ADDRESS);
	}
	
	public void addCredentialsTable() throws SQLException {
		stmt = conn.createStatement();
		stmt.execute("CREATE TABLE IF NOT EXISTS Credentials (ID INTEGER NOT NULL UNIQUE, Username	VARCHAR, Email VARCHAR, Password BLOB, PRIMARY KEY(ID AUTOINCREMENT))");
		stmt.close();
	}
	
	public boolean addNewUser(String username, String email, byte[] password) {
		try {
			pStmt = conn.prepareStatement("INSERT INTO Credentials (Username, Email, Password) VALUES (?,?,?)");
			pStmt.setString(1, username);
			pStmt.setString(2, email);
			pStmt.setBytes(3, password);
			return pStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getID(String username) {
		try {
			pStmt = conn.prepareStatement("SELECT ID FROM Credentials WHERE Username = ?");
			pStmt.setString(1, username);
			rs = pStmt.executeQuery();
			rs.next();
			int returnInt = rs.getInt("ID");
			pStmt.close();
			return returnInt;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public String getUsername(int ID) {
		try {
			pStmt = conn.prepareStatement("SELECT Username FROM Credentials WHERE ID = ?");
			pStmt.setInt(1, ID);
			rs = pStmt.executeQuery();
			rs.next();
			String returnString = rs.getString("Username");
			pStmt.close();
			return returnString;
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public String getEmail(int ID) {
		try {
			pStmt = conn.prepareStatement("SELECT Email FROM Credentials WHERE ID = ?");
			pStmt.setInt(1, ID);
			rs = pStmt.executeQuery();
			rs.next();
			String output = rs.getString("Email");
			pStmt.close();
			return output;
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public byte[] getPassword(int ID) {
		try {
			pStmt = conn.prepareStatement("SELECT Password FROM Credentials WHERE ID = ?");
			pStmt.setInt(1, ID);
			rs = pStmt.executeQuery();
			rs.next();
			byte[] output = rs.getBytes("Password");
			pStmt.close();
			return output;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean setUsername(int ID, String username) {
		try {
			pStmt = conn.prepareStatement("UPDATE Credentials SET Username = ? WHERE ID = ?");
			pStmt.setString(1, username);
			pStmt.setInt(2, ID);
			pStmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setEmail(int ID, String email) {
		try {
			pStmt = conn.prepareStatement("UPDATE Credentials SET Email = ? WHERE ID = ?");
			pStmt.setString(1, email);
			pStmt.setInt(2, ID);
			pStmt.executeUpdate();
			pStmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setPassword(int ID, String password) {
		try {
			pStmt = conn.prepareStatement("UPDATE Credentials SET Password = ? WHERE ID = ?");
			pStmt.setString(1, password);
			pStmt.setInt(2, ID);
			pStmt.executeUpdate();
			pStmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
