package promotion;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class Mail {
	private static final String SERVEXC = "An error occured";
	private static final Logger LOG = Logger.getLogger(Mail.class);
	private static String host = "smtp.gmail.com";
	private static String user = "flysmm17@gmail.com";
	private static String pass = "flysmm2017";

	public void sendMail(String mail, String text) throws MessagingException {
		// Set up the SMTP server.
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.ssl.trust", host);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, null);

		// Construct the message
		String to = mail;
		String from = "flysmm17@gmail.com";
		String subject = "FlySMM";
		Message msg = new MimeMessage(session);
		try {
		    msg.setFrom(new InternetAddress(from));
		    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		    msg.setSubject(subject);
		    msg.setText(text);
		    
		    // Send the message.
		    Transport.send(msg, user, pass);
		} catch (MessagingException e) {
			// Error.
			LOG.info(SERVEXC, e);
			}
		}
	
	public Mail() {
		super();
	}
}
