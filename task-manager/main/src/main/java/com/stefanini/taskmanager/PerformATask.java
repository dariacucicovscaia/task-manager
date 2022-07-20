package com.stefanini.taskmanager;

import java.util.Scanner;

import com.stefanini.taskmanager.command.ChooseCommandImpl;

public class PerformATask implements Runnable {

	@Override
	public void run() {

		Scanner scanner = new Scanner(System.in);

		ChooseCommandImpl command = new ChooseCommandImpl();
		command.chooseCommand(scanner).execute();

	}

}
