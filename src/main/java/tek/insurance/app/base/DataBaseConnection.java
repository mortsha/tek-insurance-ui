package tek.insurance.app.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	public static void main(String[] args) {

		String url = "jdbc:mysql://tek-database-server.mysql.database.azure.com:3306/tek_insurance_app?useSSL=true&requireSSL=false";
		String port = "3306";
		String dataBaseName = "tek_insurance_app";
		String username = "tek_student_user";
		String password = "MAY_2022";

		try {
			// create a connection to database
			Connection connection = DriverManager.getConnection(url, username, password);
			
			// create statement using connection
			Statement statement = connection.createStatement();
			
			// using statement execute queries. and return resultset
			String query = "select * from primary_person";
			ResultSet resultSet = statement.executeQuery(query);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
