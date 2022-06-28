package com.stefanini.taskmanager.sendMail;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SendMailAspect {

	@After("@annotation(com.stefanini.taskmanager.sendMail.SendMail) && args(firstName, lastName, userName)")
	public void createUserMailSend(String firstName, String lastName, String userName) {
		System.out.println("Its working");
		MailUtil.createUserEmailMessage("Daria.Cucicovscaia@stefanini.com", "Daria.Cucicovscaia@stefanini.com",
				firstName, userName);
	}

	@After("@annotation(com.stefanini.taskmanager.sendMail.SendMail) && args(userName, taskTitle)")
	public void assignTaskMailSend(String userName, String taskTitle) {
		// System.out.println("Its working");
		MailUtil.assignTaskEmailMessage("Daria.Cucicovscaia@stefanini.com", "Daria.Cucicovscaia@stefanini.com",
				userName, taskTitle);
		;
	}

	@After("@annotation(com.stefanini.taskmanager.sendMail.SendMail) && args(firstName, lastName, userName, taskTitle, taskDescription )")
	public void createUserAndAddTask(String firstName, String lastName, String userName, String taskTitle,
			String taskDescription) {
		System.out.println("Its working");
		MailUtil.createUserEmailMessage("Daria.Cucicovscaia@stefanini.com", "Daria.Cucicovscaia@stefanini.com",
				firstName, userName);
		MailUtil.assignTaskEmailMessage("Daria.Cucicovscaia@stefanini.com", "Daria.Cucicovscaia@stefanini.com",
				userName, taskTitle);
		;
	}
}