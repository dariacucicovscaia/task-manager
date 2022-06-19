package com.stefanini.taskmanager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class DataBaseConnection extends ALoadProperties {
	private static Connection con = null;

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
