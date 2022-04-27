package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//This demonstrates the Singleton Design Pattern. A single DbConnection object is created when the class is loaded.

public final class DBConnection {

	private final static String URL = "jdbc:mysql://localhost:3306/colorsNew";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Codingclass2";
	private Connection connection;
	private final static DBConnection instance = new DBConnection();

	private DBConnection() {
	}
	public static DBConnection instance() {
		return instance;
	}

	public Connection getConnection() {
		//The connection is only created if it does not exist. Otherwise it is reused. 
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("Connection successful!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}
