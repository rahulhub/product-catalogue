package com.uru.app.business.util;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class EmailNotification {
	
    public static void sendMail(String emailText,String[] mailAddressTo) throws NamingException, AddressException, MessagingException  
    {
    	  String smtpServer = "smtp.rediffmailpro.com";
	      int port = 587;
	      final String userid = "support@izigro.com";
	      final String password = "123support";
	      String from = "support@izigro.com";
	      
	      Properties props = new Properties();

	      props.put("mail.smtp.auth", "true");
	      //props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.debug", "true");
	      props.put("mail.smtp.host", smtpServer);
	      props.put("mail.smtp.port", "587");
	      props.put("mail.transport.protocol", "smtp");
	      
	      props.put("mail.smtp.from", from);

	      Session mailSession = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(userid, password);
	            }
	         });

	      MimeMessage message = new MimeMessage(mailSession);
	      message.addFrom(InternetAddress.parse(from));
	      
	      InternetAddress[] mailAddress_TO = new InternetAddress [mailAddressTo.length] ;
	      for(int i=0;i<mailAddressTo.length;i++){
	             mailAddress_TO[i] = new InternetAddress(mailAddressTo[i]);
	      }
	      message.addRecipients(Message.RecipientType.TO, mailAddress_TO);
	      message.setSubject("support@izigro");
	      message.setText(emailText);
	      message.setContent(emailText,"text/html");
	      Transport transport = mailSession.getTransport();
	      try {
	         transport.connect(smtpServer, port, userid, password);
	         transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      transport.close();
    }

}