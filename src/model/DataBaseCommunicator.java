package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseCommunicator implements IConstants{
	
	private String connectionUrl;
	private String userName;
	private String password;
	
	public DataBaseCommunicator() {
		this.connectionUrl = "jdbc:mysql://localhost:3306/progra1";
		this.userName = "root";
		this.password = "vmDTNoK1&b";
	}
	
	public void testConnection() {
		try (Connection con = DriverManager.getConnection(connectionUrl, userName, password); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM cliente";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("nombre"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	
	public static void main(String[] args) {
		DataBaseCommunicator dbc = new DataBaseCommunicator();
		dbc.testConnection();
	}
}

