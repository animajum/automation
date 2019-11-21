package com.w2a.utilities;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.zeroturnaround.zip.ZipUtil;



public class MonitoringMail
{
	//public static void sendMail(String mailServer, String from,String username, String password,String port, String[] to, String subject, String messageBody, String attachmentPath, String attachmentName) throws MessagingException, AddressException
	public void sendMail(String mailServer, String from, String[] to, String subject, String messageBody) throws MessagingException, AddressException
	{
		
		
	    final String username = "animesh.majumder@talentmsh.com";  // like yourname@outlook.com
	    final String password = "mshG2022#";   // password here

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp-mail.outlook.com");
	    props.put("mail.smtp.port", "587");
		
	    Session session = Session.getInstance(props,
	    	      new javax.mail.Authenticator() {
	    	        @Override
	    	        protected PasswordAuthentication getPasswordAuthentication() {
	    	            return new PasswordAuthentication(username, password);
	    	        }
	    	      });
	    	    session.setDebug(true);

	    	    try {

	    	        Message message = new MimeMessage(session);
	    	        message.setFrom(new InternetAddress(username));
	    	        message.setRecipients(Message.RecipientType.TO,
	    	            InternetAddress.parse("sayan.bhattacharya@talentmsh.com"));   // like inzi769@gmail.com
	    	        message.setSubject("Aeon ATS Regression Test Report");
	    	        
	    	        // Create the message part
	    	         BodyPart messageBodyPart = new MimeBodyPart();

	    	         // Now set the actual message
	    	         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    	         LocalDateTime now = LocalDateTime.now();  
	    	         messageBodyPart.setText("Aeon Automation Test Report : Execution Date" +  now);

	    	         // Create a multipar message
	    	         Multipart multipart = new MimeMultipart();

	    	         // Set text message part
	    	         multipart.addBodyPart(messageBodyPart);

	    	         // Part two is attachment
	    	         messageBodyPart = new MimeBodyPart();
	    	         ZipUtil.pack(new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\"), new File(System.getProperty("user.dir") + "\\target\\TestReport.zip"));
	    	         String filename = System.getProperty("user.dir") + "\\target\\TestReport.zip";
	    	         DataSource source = new FileDataSource(filename);
	    	         messageBodyPart.setDataHandler(new DataHandler(source));
	    	         messageBodyPart.setFileName("Automated_Regression_Test_Report.zip");
	    	         multipart.addBodyPart(messageBodyPart);

	    	         // Send the complete message parts
	    	         message.setContent(multipart);
	    	      // Send message

	    	        Transport.send(message);

	    	        System.out.println("Done");

	    	    } catch (MessagingException e) {
	    	        throw new RuntimeException(e);
	    	    }
	    
		/*boolean debug = false;
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable","true");
		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.host", mailServer); 
		props.put("mail.debug", "true");
		
	     props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
	     props.setProperty("mail.smtp.socketFactory.fallback", "false");   
	     props.setProperty("mail.smtp.port", "465");   
	     props.setProperty("mail.smtp.socketFactory.port", "465"); 

		
		  Authenticator auth = new SMTPAuthenticator();
		    Session session = Session.getDefaultInstance(props, auth);

		    session.setDebug(debug);
		
		try
		{
			
			
			Transport bus = session.getTransport("smtp");
			bus.connect();
            Message message = new MimeMessage(session);
        
         //X-Priority values are generally numbers like 1 (for highest priority), 3 (normal) and 5 (lowest).
            
             message.addHeader("X-Priority", "1");
             message.setFrom(new InternetAddress(from));
             InternetAddress[] addressTo = new InternetAddress[to.length];
             for (int i = 0; i < to.length; i++)
      		 addressTo[i] = new InternetAddress(to[i]);
             message.setRecipients(Message.RecipientType .TO, addressTo);
             message.setSubject(subject);
                  
             
             BodyPart body = new MimeBodyPart();

            // body.setText(messageBody);
            body.setContent(messageBody,"text/html");

             //BodyPart attachment = new MimeBodyPart();
             //DataSource source = new FileDataSource(attachmentPath);
            // attachment.setDataHandler(new DataHandler(source));
             //attachment.setFileName(attachmentName);
             MimeMultipart multipart = new MimeMultipart();
             multipart.addBodyPart(body);
            // multipart.addBodyPart(attachment);
             message.setContent(multipart);
             Transport.send(message);
             System.out.println("Sucessfully Sent mail to All Users");
         	 bus.close();
    		
		}
		catch (MessagingException mex)
		{
            mex.printStackTrace();
        }	*/	
	} 
	
	private class SMTPAuthenticator extends javax.mail.Authenticator
	{

	    public PasswordAuthentication getPasswordAuthentication()
	    {
	        String username = TestConfig.from;
	        String password = TestConfig.password;
	        return new PasswordAuthentication(username, password);
	    }
	}
	
}
