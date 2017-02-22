package frontController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import org.hibernate.Session;

import sale.Flight;
import sale.Price;
import servlets.SessionFactorySingleton;

public class SaleCommand extends FrontCommand {

	private static final String FLIGHTS = "flights";
	private static final String RDATE = "rDate";
	private static final String DDATE = "dDate";

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("GDF")) {
			getDepartureFromDb();
		}
		if (caller.equals("GRF")) {
			getReturnFromDb();
		}
	}

	public void getDepartureFromDb() {

		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		org.hibernate.Query query = session.createQuery("Select icao from Airport " + "where name=?");

		query = query.setParameter(0, request.getParameter("aDeparture"));
		List result = query.list();
		String departure = (String) result.get(0);

		org.hibernate.Query queryArrivalAirport = session.createQuery("Select icao from Airport " + "where name = ?");

		queryArrivalAirport = queryArrivalAirport.setParameter(0, request.getParameter("aArrival"));
		result = queryArrivalAirport.list();
		String arrival = (String) result.get(0);

		request.getSession().setAttribute("aIcao", arrival);
		request.getSession().setAttribute("dIcao", departure);

		org.hibernate.Query queryInnerJoin = session.createQuery("from Price p inner join p.flight f "
				+ "where f.departureAirport.icao = ? " + "and f.arrivalAirport.icao = ? " + "and f.departureDate = ? "
				+ "group by f.idFlight, p.seats.tariff");

		queryInnerJoin = queryInnerJoin.setParameter(0, departure);
		queryInnerJoin = queryInnerJoin.setParameter(1, arrival);
		queryInnerJoin = queryInnerJoin.setDate(2, parseStringToDate(DDATE));

		List result1 = queryInnerJoin.list();
		System.out.println(result1.size());

		List<Flight> flights = new ArrayList<Flight>();
		for (Object[] o : (List<Object[]>) result1) {
			Price p = (Price) o[0];
			p.setDiscountedAmount(p.getAmount());
			Flight f = (Flight) o[1];
			Flight fp = new Flight(f, p);
			checkforPromos(fp);
			flights.add(fp);
		}
		// session.getTransaction().commit();
		request.getSession().setAttribute("flights", flights);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/departure_flights.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getReturnFromDb() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		String departure = (String) request.getSession().getAttribute("aIcao");
		String arrival = (String) request.getSession().getAttribute("dIcao");

		org.hibernate.Query queryFlyPrice = session.createQuery("from Price p inner join p.flight f "
				+ "where f.departureAirport.icao =? " + "AND f.arrivalAirport.icao =? " + "AND f.departureDate =? "
				+ "group by f.idFlight, p.seats.tariff");

		queryFlyPrice = queryFlyPrice.setParameter(0, departure);
		queryFlyPrice = queryFlyPrice.setParameter(1, arrival);
		queryFlyPrice = queryFlyPrice.setParameter(2, parseStringToDate(RDATE));

		List result = queryFlyPrice.list();
		List<Flight> flights = new ArrayList<Flight>();
		for (Object[] o : (List<Object[]>) result) {
			Price p = (Price) o[0];
			p.setDiscountedAmount(p.getAmount());
			Flight f = (Flight) o[1];
			Flight fp = new Flight(f, p);
			checkforPromos(fp);
			flights.add(fp);
		}
		// session.getTransaction().commit();
		request.getSession().removeAttribute(FLIGHTS);
		request.getSession().setAttribute(FLIGHTS, flights);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/return_flights.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Date parseStringToDate(String option) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = (String) request.getSession().getAttribute(option);
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	private Flight checkforPromos(Flight flight) {
		if (flight.getPrice().getPromo() != null) {
			float amount = flight.getPrice().getAmount();
			int discount = flight.getPrice().getPromo().getDiscountRate();
			if (flight.getPrice().getPromo().isFidelity()) {
				flight.getPrice().setDiscountedAmount(amount - (amount * discount / 100));
			} else {
				flight.getPrice().setAmount(amount - (amount * discount / 100)); 
				flight.getPrice().setDiscountedAmount(amount - (amount * discount / 100));
			}
		}
		return flight;
	}
}
