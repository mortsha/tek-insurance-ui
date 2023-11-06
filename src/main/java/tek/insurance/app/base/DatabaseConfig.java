package tek.insurance.app.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig extends BaseSetup {
	private Connection connection;

	public void connectToDatabase() {
		String url = "jdbc:mysql://tek-database-server.mysql.database.azure.com:3306/tek_insurance_app?useSSL=true&requireSSL=false";
		String username = "tek_student_user";
		String password = "MAY_2022";
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new RuntimeException("Failed to establish a database connection " + e.getMessage());
		}
	}

	public ResultSet runQuery(String query) {
		try {
			Statement statement = connection.createStatement();
			return statement.executeQuery(query);
		} catch (SQLException e) {
			throw new RuntimeException("Failed to execute the database query " + e.getMessage());
		}
	}

	public void closeDatabaseConnection() {
		if(connection !=null) {
			try {
				connection.close();
				System.out.println("Database connection closed successfully");
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection " + e.getMessage());
			}
		}
	}
}
