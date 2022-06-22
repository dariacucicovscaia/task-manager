package com.stefanini.taskmanager;

import java.io.IOException;
import java.sql.SQLException;
import com.stefanini.taskmanager.command.ChoseCommand;

public class CLIApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		if(args.length ==0) {
			System.err.println("calling w-o arguments");
		}
		
		ChoseCommand command = new ChoseCommand() ;
		command.choseCommand(args);
	}
}