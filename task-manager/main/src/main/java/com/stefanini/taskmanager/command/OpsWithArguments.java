package com.stefanini.taskmanager.command;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OpsWithArguments {
	protected Scanner scanner;

	public OpsWithArguments(Scanner scanner) {
		this.scanner = scanner;
	}

	public String valueBetweenApostrohe(String string) {
		String ValueWeNeed = null;
		String[] paras = string.split("\n");
		Pattern pattern = Pattern.compile("'(.*?)'");
		for (int i = 0; i < paras.length; i++) {
			Matcher matcher = pattern.matcher(paras[i]);
			while (matcher.find()) {
				ValueWeNeed = matcher.group(1);
			}
		}

		return ValueWeNeed;
	}

}
