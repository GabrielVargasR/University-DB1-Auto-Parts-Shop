package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseCommunicator {
	public static void main(String[] args) {

		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Progra1;user=SA;password=<Progra1Bases1>";

      try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
          String SQL = "SELECT * FROM test_table";
          ResultSet rs = stmt.executeQuery(SQL);

          // Iterate through the data in the result set and display it.
          while (rs.next()) {
              System.out.println(rs.getInt("num") + " " + rs.getString("str"));
          }
      }
      // Handle any errors that may have occurred.
      catch (SQLException e) {
          e.printStackTrace();
      }
  }
}
