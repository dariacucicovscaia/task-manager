package com.stefanini.taskmanager;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.stefanini.taskmanager.command.ChoseCommand;

public class CLIApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		Logger logger = Logger.getLogger(CLIApp.class);
		BasicConfigurator.configure();
		
		if (args.length == 0) {
			logger.error("calling without arguments");
		}

		ChoseCommand command = new ChoseCommand();
		command.choseCommand(args);
	}
}