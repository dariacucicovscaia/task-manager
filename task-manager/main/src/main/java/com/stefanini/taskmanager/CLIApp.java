package com.stefanini.taskmanager;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.stefanini.taskmanager.command.ChooseCommandImpl;

public class CLIApp {
	public static void main(String[] args) {

		Logger logger = Logger.getLogger(CLIApp.class);
		BasicConfigurator.configure();

		logger.info("App started");

		if (args.length == 0) {
			logger.error("calling without arguments");
		}

		ChooseCommandImpl command = new ChooseCommandImpl();
		command.chooseCommand(args).execute();

	}
}