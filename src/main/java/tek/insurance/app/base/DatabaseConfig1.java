package tek.insurance.app.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig1 {
	private Connection connection;
	String url = "";
	public DatabaseConfig1(String url, String username, String password) {
		try {
			 connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to connect to the database");
		}
	}
	
	
	public ResultSet executeQuery(String query) throws SQLException {
		 PreparedStatement statement = connection.prepareStatement(query);
			return statement.executeQuery();

	}
	public void closeConnection()  {
		try {
			if(connection!=null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}
