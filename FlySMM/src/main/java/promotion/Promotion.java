package promotion;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public abstract class Promotion {
	protected int discountRate;
	protected boolean fidelity;
	protected long idPromo;
	protected String name;
	
	public void sendMail(String mail) {
		// Set up the SMTP server.
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", "smtp.myisp.com");
		Session session = Session.getDefaultInstance(props, null);

		// Construct the message
		String to = mail;
		String from = "flysmm@gmail.com";
		String subject = "Promotions";
		Message msg = new MimeMessage(session);
		try {
		    msg.setFrom(new InternetAddress(from));
		    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		    msg.setSubject(subject);
		    msg.setText("There is a new Promotion:"+this.name+"! Checkout on our website");
		    
		    // Send the message.
		    Transport.send(msg);
		} catch (MessagingException e) {
			// Error.
			}
		}
	
	public abstract void notify_();
	
	public Promotion(){}
}