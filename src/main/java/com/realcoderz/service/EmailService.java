package com.realcoderz.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	

		public boolean sendEmail(String subject, String message, String... to)
		{
			
			boolean f=false;
			
			String from="gauri.aman0@gmail.com";
			
			String host="smtp.gmail.com";
			//String recepient="";
			Properties prop=new Properties();
			System.out.println("Properties" +prop);
			
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.port", "465");
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.auth", "true");
			
			Session session=Session.getInstance(prop, new Authenticator() {
				
				protected PasswordAuthentication getPasswordAuthentication() {
					return  new PasswordAuthentication("gauri.aman0@gmail.com", "icxvlqvywnfhpccs");
				}
			});
			
			session.setDebug(true);
			InternetAddress[] myList = new InternetAddress[to.length];
			
			for(int i = 0; i< to.length; i++)
			{
				InternetAddress address = new InternetAddress();
				address.setAddress(to[i]);
				myList[i] = address;
			}
			
			MimeMessage m=new MimeMessage(session);
			
			try {
				m.setFrom(from);
				
				//m.addRecipients(Message.RecipientType.TO, to);
				m.addRecipients(Message.RecipientType.TO, myList);
				m.setSubject(subject);
				
				m.setText(message);
				
				Transport.send(m);
				
				System.out.println("sent");
				f=true;
			}
			catch(Exception ex) {System.out.println(ex);}
			 
			return f;
		}
		
}
	

