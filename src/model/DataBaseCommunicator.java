package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseCommunicator implements IConstants{
	
	public DataBaseCommunicator() { }
	
	public ResultSet queryDB(String pQuery) {
		try (Connection connection = DriverManager.getConnection(DB_CONNECTION_URL); Statement statement = connection.createStatement();) {
	          ResultSet resultSet = statement.executeQuery(pQuery);
	          return resultSet;
	      }
	      // Handle any errors that may have occurred.
	      catch (SQLException e) {
	          e.printStackTrace();
	          return null;
	      }
	}
	
	public static void main(String[] args) {

      try (Connection con = DriverManager.getConnection(DB_CONNECTION_URL); Statement stmt = con.createStatement();) {
          String SQL = "SELECT * FROM test_table";
          ResultSet rs = stmt.executeQuery(SQL);
          
          rs.updateString("str", "prueba");
    	  rs.updateRow();

          // Iterate through the data in the result set and display it.
          while (rs.next()) {
              System.out.println(rs.getInt("num") + " " + rs.getString("str"));
          }
          
          rs.absolute(1);
          rs.updateString("str", "prueba");
    	  rs.updateRow();
      }
      // Handle any errors that may have occurred.
      catch (SQLException e) {
          e.printStackTrace();
      }
//		DataBaseCommunicator dbc = new DataBaseCommunicator();
//		ResultSet rs = dbc.queryDB("SELECT * FROM test_table");
//		try {
//			while (rs.next()) {
//				System.out.println(rs.getInt("num") + " " + rs.getString("str"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
  }
}
