package com.stefanini.taskmanager;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class CLIApp extends PerformATask {
	static final int FIXED_THREAD_POOL_SIZE = 5;

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(CLIApp.class);
		BasicConfigurator.configure();

		System.err.println("Input data to create a User and a Task: ");

		ExecutorService threadPoolExecutorService = Executors.newFixedThreadPool(FIXED_THREAD_POOL_SIZE);

		for (int i = 0; i < FIXED_THREAD_POOL_SIZE; i++) {
			try {
				threadPoolExecutorService.submit(new PerformATask()).get();
			} catch (InterruptedException | ExecutionException e) {
				logger.error(e.getMessage());
			}
		}
		threadPoolExecutorService.shutdown();

		if (threadPoolExecutorService.isShutdown() == true) {
			System.out.println("FINISHED!");
		}

	}
}
