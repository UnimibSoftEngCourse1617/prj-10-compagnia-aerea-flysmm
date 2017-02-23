package promotion;

import java.util.List;

import javax.mail.MessagingException;

import org.hibernate.Session;

import sale.Flight;
import sale.Price;
import servlets.SessionFactorySingleton;

public class FlightPromotion extends Promotion{
	
	private static final long serialVersionUID = 1L;
	
	private Flight flight;

	public FlightPromotion(){
		super();
	}
	
	public FlightPromotion(Flight flight) throws MessagingException{
		this.promoType = "flight";
		this.setFlight(flight);
		this.notify_("There is a new Promotion, check it out in our website");
	}
	
	public FlightPromotion(String idPromo, int discountRate, boolean fidelity, String name, String description, Flight flight) throws MessagingException{
		this.idPromo = idPromo;
		this.discountRate = discountRate;
		this.fidelity = fidelity;
		this.name = name;
		this.description = description;
		this.promoType = "flight";
		this.setFlight(flight);
		this.notify_("There is a new Promotion, check it out in our website");
	}
	
	@SuppressWarnings("unchecked")
	public Flight getFlight() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Price> result = session
				.createQuery("from Price where promotion_IdPromo = '"+this.idPromo+"'")
				.list();
		
		String id = result.get(0).getFlight().getIdFlight();
		
		List<Flight> result1 = session.
				createQuery("from Flight where Flight_ID = '"+id+"'")
				.list();
		
		return result1.get(0);
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	@Override
	public String toString() {
		return "FlightPromotion [getIdPromo()=" + getIdPromo() + ", getDiscountRate()=" + getDiscountRate() + ", getFidelity()="
				+ isFidelity() + ", getName()=" + getName()
				+ ", getDescription()=" + getDescription() + ", getFlight()=" + getFlight() + "]";
	}

}