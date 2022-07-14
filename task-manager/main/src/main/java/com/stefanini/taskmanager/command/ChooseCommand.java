package com.stefanini.taskmanager.command;

import java.util.Scanner;

import com.stefanini.taskmanager.command.acctions.Command;

public interface ChooseCommand {
	/**
	 * User can chose a command with the adequate arguments
	 * 
	 * @param args arguments witch are passed with the start of the program
	 * @return executes a command
	 */
	Command chooseCommand(Scanner scanner);
}
