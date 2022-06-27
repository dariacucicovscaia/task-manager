package com.stefanini.taskmanager.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LoadDBProperties {

	protected Properties loadProperties(String propertiesFilename) {
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
}
