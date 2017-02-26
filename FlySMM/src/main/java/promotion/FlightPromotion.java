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
	public Flight getFlight(){
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		
		String query1 = "from Price where promotion_IdPromo = :id";
		List<Price> result = session
				.createQuery(query1)
				.setString("id", this.idPromo)
				.list();

		String query2 = "from Flight where Flight_ID = :idf";
		List<Flight> result1 = session.
				createQuery(query2)
				.setString("idf", result.get(0).getFlight().getIdFlight())
				.list();
		
		this.flight = result1.get(0);
		return this.flight;
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