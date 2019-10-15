package project.utils;

import java.util.Properties;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import project.library.ApplicationMethods;
import project.library.CommonMethods;

public class Email_Send extends CommonMethods {

	String html;
	public final int usernamecolumn = 6;

	@Test
	public void sendEmail(String excelsheetfilePath) {

		final String username = LoginCredentails("USERNAME_WITHOUTDOMAIN");
		final String password = LoginCredentails("PASSWORD");

		Properties props = new Properties();
		props.put("mail.smtp.auth", false);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp2.expoexchange.com");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
	
			 message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("sreejak@infinite.com,Chandrasekhar.Kulandasamy@experient-inc.com,Sirasanambati.Anudeep@infinite.com"));
//			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("Chandrasekhar.Kulandasamy@experient-inc.com"));

			// message.setText("PFA");

			// MimeBodyPart messageBodyPart = new MimeBodyPart();
			
			message.setSubject("Automation Report for DP Application");

			BodyPart messageBodyPart = new MimeBodyPart();
			BodyPart attachmentPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			messageBodyPart = new MimeBodyPart();
			String file = excelsheetfilePath;
			String fileName = "DP Test Cases.xlsx";
			DataSource source = new FileDataSource(file);
			attachmentPart.setDataHandler(new DataHandler(source));
			attachmentPart.setFileName(fileName);

			// Get the count of Failures

			int count = 0;
			for (int i = 1; i <= ApplicationMethods.excelsheet.getRowCount("DP Test Cases"); i++) {
				String result = ApplicationMethods.excelsheet.getCellData("DP Test Cases", usernamecolumn, i);
				if (result.equalsIgnoreCase("Fail")) {
					count++;
				}
			}
			if (count == 0) {
				html = "<p>Hi,</p><p>PFA the Automation Test report.</p><p>Note: All are Passed :-) </p><p>Thanks,</p><p>Chandra</p>";
			} else if (count == 1) {
				html = "<p>Hi,</p><p>PFA the Automation Test report.</p><p>Note: There is one failure.. </p><p>Thanks,</p><p>Chandra</p>";
			} else {
				html = "<p>Hi,</p><p>PFA the Automation Test report.</p><p>Note: There are " + count
						+ " failures.. </p><p>Thanks,</p><p>Chandra</p>";
			}

			messageBodyPart.setContent(html, "text/html");
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachmentPart);

			message.setContent(multipart);

			System.out.println("Sending");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}