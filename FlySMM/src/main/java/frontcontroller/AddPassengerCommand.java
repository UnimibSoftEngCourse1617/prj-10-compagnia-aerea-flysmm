package frontcontroller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import booking.Baggage;
import booking.Passenger;
import customer.Customer;
import sale.Flight;
import servlets.SessionFactorySingleton;

public class AddPassengerCommand extends FrontCommand {
	private static final String SERVEXC = "An error occured";
	private static final Logger LOG = Logger.getLogger(AddPassengerCommand.class);

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("GDF")) {
			HttpSession session = request.getSession();
			ArrayList<Passenger> listPassenger = new ArrayList<Passenger>();
			ArrayList<Integer> priceBaggage = new ArrayList<Integer>();
			Customer c = (Customer) request.getSession().getAttribute("Customer");
			String nPass = (String) request.getSession().getAttribute("passengers");
			int length = Integer.parseInt(nPass);
			for (int i = 0; i < length; i++) {
				String name = request.getParameter("name" + i);
				String surname = request.getParameter("surname" + i);
				String fiscalCode = request.getParameter("fiscalCode" + i);
				String date = request.getParameter("dateOfBirth" + i);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String docCode = request.getParameter("docCode" + i);
				String docType = request.getParameter("docType" + i);
				String baggage = request.getParameter("baggage" + i);
				Date dataBirth = null;

				try {
					dataBirth = sdf.parse(date);
				} catch (Exception e) {
					LOG.info(SERVEXC, e);
				}
				Passenger p = new Passenger(fiscalCode, name, surname, docCode, docType, dataBirth, baggage);
				Passenger tmp = this.getPassengerFromDb(p);
				if (tmp == null) {
					writePassenger(p);
					listPassenger.add(p);
				} else {
					listPassenger.add(p);
				}
				priceBaggage.add(this.getBaggagePriceFromDb(p));
			}
			session.setAttribute("listPassenger", listPassenger);
			session.setAttribute("priceBaggage", priceBaggage);
			ArrayList<Flight> listFlight = new ArrayList<Flight>();
			try {
				Flight departure = (Flight) request.getSession().getAttribute("chosenDeparture");
				Flight arrival = (Flight) request.getSession().getAttribute("chosenReturn");

				listFlight.add(departure);
				if (!departure.equals(arrival)) {
					listFlight.add(arrival);
				}
			} catch (Exception e) {
				listFlight.clear();
				listFlight.add((Flight) request.getSession().getAttribute("chosenDeparture"));
				LOG.error("An error occured", e);
			}

			session.setAttribute("listFlight", listFlight);
			session.setAttribute("Customer", c);

		}
	}

	public static void writePassenger(Passenger p) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(p);
		session.getTransaction().commit();
	}

	public Integer getBaggagePriceFromDb(Passenger p) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.getTransaction().begin();
		Baggage bag;
		Query query = session.createQuery("from Baggage " + " WHERE ID_Baggage = :baggage");
		query.setParameter("baggage", p.getBaggageId());
		List result = query.list();
		bag = (Baggage) result.get(0);
		session.getTransaction().commit();

		return bag.getPrice();
	}

	public Passenger getPassengerFromDb(Passenger p) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Passenger " + " WHERE Fiscal_code = :fiscalCode");
		query.setParameter("fiscalCode", p.getFiscal_code());
		List result = query.list();
		Passenger tmp = null;
		if (result.isEmpty()) {
			session.getTransaction().commit();
			return tmp;
		}
		tmp = (Passenger) result.get(0);
		session.getTransaction().commit();

		return tmp;
	}

}