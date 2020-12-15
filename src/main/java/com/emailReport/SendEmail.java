package com.emailReport;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.excel.ExcelUpdate;
import com.extent.ExtentReporter;

@SuppressWarnings("unused")
public class SendEmail {

	public static void EmailReport() {
		String fileName1 = ExtentReporter.filePath;
		int passCount = ExcelUpdate.passCounter;
		int failCount = ExcelUpdate.failCounter;
		int warnCount = ExcelUpdate.warningCounter;

		// mail extent reports
//		String[] to = {"murali.appadi@zee.com","durgesh.panda@zee.com"};
//		String[] cc = {"basavaraj.pn@igsindia.net", "shreenidhi.g@igsindia.net","hitesh.c@igsindia.net","Tanisha.c@igsindia.net","kushal.revankar@igsindia.net","abhilash.s@igsindia.net","kaushik.mr@igsindia.net","Karthikeyan.S@igsindia.net","indu.karunakaran@zee.com","raksha.gs@igsindia.net","deepak.prakash@igsindia.net"};

		String[] to = {"hitesh.c@igsindia.net"};
		String[] cc = {};
		String[] bcc = {};

		sendMail("zeeautomationigs@gmail.com", "ZeeAutomation@123", "smtp.gmail.com", "587", "true", "true", true, "javax.net.ssl.SSLSocketFactory",
				"false", to, cc, bcc, "Android TV Analysed Report, APP verison - 20.21106.3", ExtentReporter.updateResult(),fileName1);
	}

	public static boolean sendMail(final String userName, final String passWord, String host, String port,
			String starttls, String auth, boolean debug, String socketFactoryClass, String fallback, String[] to,
			String[] cc, String[] bcc, String subject, StringBuilder text, String attachmentPath) {
		
		String textTable1 ="Hi Team,<br/>Please find attacthed test automation execution results."
				+"<br>"
				+"<html>\r\n"
				+"<br>"
				+"<h3><table align=\"center\" "+"TV"+"</h3>\n\n"
				+ "      <table width=\"600\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" style=\"border:1px solid #ccc;\">\r\n"
				+ "        <tr>\r\n"
				+ "          <td> Number of Total Test </span></td>\r\n"
				+ "          <td><span style=\"font-weight:bold\"> Number of Test Passed </span></td>\r\n"
				+ "          <td><span style=\"font-weight:bold\"> Number of Test Failed </span></td>\r\n"
				+ "        </tr>\r\n"
				+ text
				+ "      </table>\r\n\n\n"
				+ "</html>"
				+"<br/> Regards,<br> IGS Automation Team";

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", starttls);
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		try {
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, passWord);
				}
			});

			MimeMessage msg = new MimeMessage(session);
			msg.setSubject(subject);
			// attachment start
			// create the message part
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();  
//		    messageBodyPart1.setText(text); 

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentPath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(ExtentReporter.fileName);
			
			messageBodyPart1.setText(textTable1, "utf-8", "html");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart);
			
			   
			// attachment ends
			// Put parts in message
//			System.out.println(text);
//			msg.setText("Please find the reports attached.\n\n Regards\n Automation Team", "UTF-8");
			msg.setContent(multipart);
//			msg.setContent(text, "text/html");
			msg.setFrom(new InternetAddress(userName));

			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
			}

			for (int i = 0; i < cc.length; i++) {
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
			}

			for (int i = 0; i < bcc.length; i++) {
				msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i]));
			}
			msg.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(host, userName, passWord);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception mex) {
			mex.printStackTrace();
			return false;
		}
	}
	
	public static void main(String [] args) {
		EmailReport();
	}
	
//	public static StringBuilder updateResult() {
//		StringBuilder builder = new StringBuilder();
//		String mailBodyPart = "Login,6,0";
//				String result[] = mailBodyPart.split(",");
//				System.out.println(result[0]+result[1]+result[2]);
//				builder.append("        <tr>\r\n" + "          <td> " + result[0] + " </td>\r\n" + "          <td> "
//						+ result[1] + " </td>\r\n" + "          <td> " + result[2] + " </td>\r\n"
//						+ "        </tr>\r\n");
//			
//			return builder;
//		
//	}
}
