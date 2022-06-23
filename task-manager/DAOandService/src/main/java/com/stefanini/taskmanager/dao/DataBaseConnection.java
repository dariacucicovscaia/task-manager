package com.stefanini.taskmanager.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class DataBaseConnection {
	private static Connection con = null;

	private Properties loadProperties(String propertiesFilename) {
		Logger logger = Logger.getLogger(DataBaseConnection.class);
		BasicConfigurator.configure();

		Properties prop = new Properties();

		ClassLoader loader = this.getClass().getClassLoader();
		try (InputStream stream = loader.getResourceAsStream(propertiesFilename)) {
			if (stream == null) {
				throw new FileNotFoundException();
			}
			prop.load(stream);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return prop;
	}

	static {
		String propertiesFilename = "config.properties";
		Properties prop = new DataBaseConnection().loadProperties(propertiesFilename);

		Logger logger = Logger.getLogger(DataBaseConnection.class);
		BasicConfigurator.configure();

		String url = prop.getProperty("url");
		String root = prop.getProperty("root");
		String password = prop.getProperty("password");

		try {

			con = DriverManager.getConnection(url, root, password);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

	public static Connection getConnection() {
		return con;
	}
}
