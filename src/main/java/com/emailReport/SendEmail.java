package com.emailReport;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.driverInstance.DriverInstance;
import com.extent.ExtentReporter;

public class SendEmail {
	
	private static String UserName = "teamviewerigs123@gmail.com";
	private static String Password = "gqvyrlfrixgizfbi";
	private static String[] to = {"shreenidhi.g@igsindia.net","hitesh.c@igsindia.net"};
	private static String[] cc = {};
	private static String[] bcc = {};

	public static void EmailReport() {
		String filepath = ExtentReporter.filePath;
		String Subject = "Zee5.com|Chrome – Jenkins Scheduled Execution HLS";
		boolean EnableAttachment = false;
		String fileName = ExtentReporter.fileName;
		String columnHeader = "Number of Total Test";
		StringBuilder InsertResult = ExtentReporter.updateResult();
		StringBuilder InsertModuleResult = ExtentReporter.updateModuleResult();
		String columnHeader2 = "Number of Test";
		String moduleName = "Module Name";
		String moduleResult = "Module Result";
		String Table ;
		
		if(DriverInstance.getPlatform().equals("TV")) {
			Subject = "Android TV Analysed Report, APP verison - 20.21106.3";
			columnHeader = "Module Name";
			InsertResult = ExtentReporter.updateTVResult();
			filepath = System.getProperty("user.dir") + "\\Analysed_Reports\\Analysed_Reports.xlsx";
			columnHeader2 = "Number of validation";
			Table ="Hi Team,<br/>Please find attached test automation execution results."
					+"<br>"
					+"<html>\r\n"
					+"<br>"
					+"<h3><table align=\"center\">"+"</h3>\n\n"
					+ "      <table width=\"600\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" style=\"border:1px solid #ccc;\">\r\n"
					+ "        <tr>\r\n"
					+ "          <td> "+columnHeader+" </span></td>\r\n"
					+ "          <td><span style=\"font-weight:bold\"> "+columnHeader2+" Passed </span></td>\r\n"
					+ "          <td><span style=\"font-weight:bold\"> "+columnHeader2+" Failed </span></td>\r\n"
					+ "        </tr>\r\n"
					+  			InsertResult
					+ "      </table>\r\n\n\n"
					+"<br>"
					+ "</html>"
					+"<br/> Regards,<br> IGS Automation Team";
		}else {

				Table ="Hi Team,<br/>Please find attached test automation execution results."
				+"<br>"
				+"<html>\r\n"
				+"<br>"
				+"<h3><table align=\"center\">"+"</h3>\n\n"
				+ "      <table width=\"600\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" style=\"border:1px solid #ccc;\">\r\n"
				+ "        <tr>\r\n"
				+ "          <td> "+columnHeader+" </span></td>\r\n"
				+ "          <td><span style=\"font-weight:bold\"> "+columnHeader2+" Passed </span></td>\r\n"
				+ "          <td><span style=\"font-weight:bold\"> "+columnHeader2+" Failed </span></td>\r\n"
				+ "        </tr>\r\n"
				+  			InsertResult
				+ "      </table>\r\n\n\n"
				+"<br>"
				+"<h3><table align=\"center\">"+"</h3>\n\n"
				+ "      <table width=\"600\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" style=\"border:1px solid #ccc;\">\r\n"
				+ "        <tr>\r\n"
				+ "          <td> "+moduleName+" </span></td>\r\n"
				+ "          <td><span style=\"font-weight:bold\"> "+moduleResult+" </span></td>\r\n"
				+ "        </tr>\r\n"
				+  			InsertModuleResult
				+ "      </table>\r\n\n\n"
				+ "</html>"
				+"<br/> Regards,<br> IGS Automation Team";
		}
		
		
		sendMail(UserName, Password, to, cc, bcc, Subject, Table, filepath,fileName,EnableAttachment);
	}

	public static boolean sendMail(final String userName, final String passWord, String[] to,String[] cc, String[] bcc, String subject,String table, String attachmentPath,String fileName, boolean EnableAttachment) {
		
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		try {
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, passWord);
				}
			});
			MimeMessage msg = new MimeMessage(session);
			Multipart multipart = new MimeMultipart();
			msg.setSubject(subject);
			MimeBodyPart messageBodyPart= new MimeBodyPart();
			if (EnableAttachment) {
				File file = new File(attachmentPath);
				if (((file.length() / (1024 * 1024)) < 25)) {
					MimeBodyPart attachBody = new MimeBodyPart();
					DataSource source = new FileDataSource(attachmentPath);
					attachBody.setDataHandler(new DataHandler(source));
					attachBody.setFileName(fileName);
					multipart.addBodyPart(attachBody);
				}
			}
			messageBodyPart.setText(table, "utf-8", "html");
			multipart.addBodyPart(messageBodyPart);
			msg.setContent(multipart);
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
			transport.connect("smtp.gmail.com", userName, passWord);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception mex) {
			mex.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		EmailReport();
	}
	
}
