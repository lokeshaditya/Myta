package Scheduler;

import java.security.Security;
import java.util.Date;
import javax.mail.Transport;

public class ScheduleMail {

	// @Override
	public void execute(String toAddress, String name ) {
		// TODO Auto-generated method stub

		String SMTP_HOST_NAME = "smtp.gmail.com";
		String SMTP_PORT = "465"; // or 567
		final String username = "sendermail";
		final String fromAddress = username + "@gmail.com";
		final String password = "password";
		String subject = "Alert!!";// request.getParameter("subject");
		String body = "Its "+name+"'s birth day tomorrow! Get ready and plan your day" ; // request.getParameter("body");

		String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		{

			// response.setContentType("text/html");
			// java.io.PrintWriter out = response.getWriter();

			try {
				// System.out.println("jj");
				Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
				java.util.Properties props = new java.util.Properties();
				props.put("mail.smtp.host", SMTP_HOST_NAME);
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", SMTP_PORT);
				props.put("mail.smtp.socketFactory.port", SMTP_PORT);
				props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
				props.put("mail.smtp.socketFactory.fallback", "false");

				javax.mail.Session session = javax.mail.Session.getInstance(props, new javax.mail.Authenticator() {
					@Override
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(username, password);
					}
				});
				javax.mail.Message msg = new javax.mail.internet.MimeMessage(session);
				msg.setFrom(new javax.mail.internet.InternetAddress(fromAddress));
				msg.setRecipient(javax.mail.Message.RecipientType.TO,
						new javax.mail.internet.InternetAddress(toAddress));
				msg.setSubject(subject);
				msg.setText(body + new Date());
				Transport.send(msg);
				System.out.println(new Date());
				System.out.println("Mail has been sent Successfully to " + toAddress+" @ "+new Date());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
