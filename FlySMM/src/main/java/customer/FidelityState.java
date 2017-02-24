package customer;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import promotion.Mail;

public class FidelityState extends State implements Serializable {

	private Date actualDateFidelity;

	public FidelityState(FidelityCustomer c) {
		super(c);
		this.actualDateFidelity = new Date();
		c.type = this.type();
	}

	// serve per cambiare lo stato da fidelity ad unfidelity
	public void changeFidelity() {

		long days = getDateDiff(this.actualDateFidelity, c.lastestBook, TimeUnit.DAYS);
		if (days > (365 * 2)) {
			c.setState(new UnfidelityState(c));
			Mail m = new Mail();
			try {
				m.sendMail(c.getEmail(), "Le comunichiamo che sono passati due anni dal suo ultimo acquisto. Il suo stato attuale è Infedele");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public String type() {
		return "Fidelity Customer";
	}

}
