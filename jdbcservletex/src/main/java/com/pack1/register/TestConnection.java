package com.pack1.register;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {
	public static Connection createconnection() {
		Connection connection = null;
		try {
			// load the properties file

			Properties properties = new Properties();
			properties.load(new FileInputStream("D:\\sravan\\Adv java\\jdbcservletex\\Connection-info.Properties"));
			// Get the data from properties file
			Class.forName(properties.getProperty("driver"));
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));

		} catch (ClassNotFoundException | SQLException  | IOException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
