package com.stefanini.taskmanager.command;

import com.stefanini.taskmanager.command.acctions.Command;

public interface ChoseCommandInterface {
	/**
	 * User can chose a command with the adequate arguments
	 * 
	 * @param args arguments witch are passed with the start of the program
	 * @return executes a command
	 */
	public Command choseCommand(String[] args);
}
