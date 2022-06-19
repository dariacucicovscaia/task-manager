package com.stefanini.taskmanager.sendMail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.stefanini.taskmanager.dao.ALoadProperties;

public class MailUtil extends ALoadProperties {
	private static Session properties() {

		Properties props = new MailUtil().loadProperties("mail.properties");

		return Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("userName"), props.getProperty("password"));
			}
		});

	}

	public static void createUserEmailMessage(String username, String recipient, String firstNameInfo,
			String userNameInfo) {

		try {
			Message message = new MimeMessage(properties());
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject("User created");
			message.setText("User " + firstNameInfo + " identified by " + userNameInfo + " has been created ");

			Transport.send(message);
			System.out.println("done");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void assignTaskEmailMessage(String username, String recipient, String taskTitleInfo,
			String userNameInfo) {
		try {
			Message message = new MimeMessage(properties());
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject("Task assigned");
			message.setText("Task " + taskTitleInfo + ", has been assigned to " + userNameInfo);

			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
