package musicPlayer.backEnd.security;

import java.security.SecureRandom;
//import java.sql.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	//generates a six digit code
	public static void generateCode(){
		Random code = new SecureRandom();
//		Main.codeNum = code.nextInt(100000,1000000);
	}
	//creates the email and puts the generated code in it then sends it to the given email address
	public static boolean sendEmail(String toEmail) {
//		generateCode();
//		try{
//			Properties props = new Properties();
//			props.put("mail.smtp.host", "smtp.gmail.com");
//			props.put("mail.smtp.socketFactory.port", "465");
//			props.put("mail.smtp.socketFactory.class",
//					"javax.net.ssl.SSLSocketFactory");
//			props.put("mail.smtp.auth", "true");
//			props.put("mail.smtp.port", "465");
//		
//			
//		
//			Session session = Session.getDefaultInstance(props, Main.auth);
//		
//			MimeMessage msg = new MimeMessage(session);
//			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//			msg.addHeader("format", "flowed");
//			msg.addHeader("Content-Transfer-Encoding", "8bit");
//
//			msg.setFrom(new InternetAddress("no_reply@passlocker.com", "NoReply-PassLocker"));
//
//			msg.setReplyTo(InternetAddress.parse("reply@passlocker.com", false));
//
//			msg.setSubject("Verification Code", "UTF-8");
//
//			msg.setText("Please enter this code into the program to continue: " + Main.codeNum, "UTF-8");
//
//			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//			Transport.send(msg); 
//			return true;
//	    }catch (Exception e) {
//	      e.printStackTrace();
	      return false;
//	    }
	}
}
