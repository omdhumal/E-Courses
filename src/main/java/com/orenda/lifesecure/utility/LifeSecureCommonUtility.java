package com.orenda.lifesecure.utility;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class LifeSecureCommonUtility {
	

	public static boolean sendEmail(String msg, String subject, String from, String to) {

		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", 465);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "gaurav@321");
			}
		};

		Session session = Session.getInstance(properties, auth);
		try {
			MimeMessage mimemsg = new MimeMessage(session);
			mimemsg.setFrom(from);
			mimemsg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimemsg.setText(msg);
			mimemsg.setSubject(subject);

			Transport.send(mimemsg);
			System.out.println("sent suceess");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
