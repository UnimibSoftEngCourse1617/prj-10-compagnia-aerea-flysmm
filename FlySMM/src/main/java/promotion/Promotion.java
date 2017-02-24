package promotion;

import java.util.List;

import javax.mail.MessagingException;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import customer.Customer;
import frontController.PromoCommand;
import servlets.SessionFactorySingleton;

public abstract class Promotion implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String SERVEXC = "An error occured";
	private static final Logger LOG = Logger.getLogger(Promotion.class);
	
	protected int discountRate;
	protected boolean fidelity;
	protected String idPromo;
	protected String name;
	protected String description;
	protected String promoType;
	
	public Promotion(){
		super();
	}
	
	public void notify_(String text) throws MessagingException{
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Customer> result = session
				.createQuery("from Customer where State_fidelity = 'Fidelity Customer'")
				.list();

		Mail m = new Mail();
		
		for (Customer c : result) {
			String email = c.getEmail();
			try{m.sendMail(email, text);
				}
			catch (MessagingException e) {
					LOG.info(SERVEXC, e);
					}
		}
		
		session.getTransaction().commit();
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public boolean isFidelity() {
		return fidelity;
	}

	public void setFidelity(boolean fidelity) {
		this.fidelity = fidelity;
	}

	public String getIdPromo() {
		return idPromo;
	}

	public void setIdPromo(String idPromo) {
		this.idPromo = idPromo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPromoType() {
		return promoType;
	}

	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}
}