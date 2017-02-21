package frontController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import org.hibernate.Session;

import sale.Flight;
import sale.Price;
import servlets.SessionFactorySingleton;

public class SaleCommand extends FrontCommand {
	
	private static final String FLIGHTS  = "flights";
	private static final String RDATE = "rDate";

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
		
		org.hibernate.Query query =  session.createQuery("Select icao from Airport where name=?");
		query = query.setParameter(0, request.getParameter("aDeparture"));
		List result = query.list();

		String departure = (String) result.get(0);
		
		////////////////////////////////////////////////////////////////////////
		org.hibernate.Query queryArrivalAirport =  session.createQuery(
				"Select icao from Airport " +
				"where name = ?");
		
		queryArrivalAirport = queryArrivalAirport.setParameter(0, request.getParameter("aArrival"));
		result = queryArrivalAirport.list();
		
		/////////////////////////////////////////////////////////////////////////
		//request.getSession().setAttribute("dIcao", departure);
		//String queryArrivalAirport = "Select icao from Airport " + "where name = '" + request.getParameter("aArrival")
		//		+ "'";
		//result = session.createQuery(queryArrivalAirport).list();

		String arrival = (String) result.get(0);
		request.getSession().setAttribute("aIcao", arrival);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		org.hibernate.Query queryInnerJoin =  session.createQuery(
				"from Price p inner join p.flight f " +
				"where f.departureAirport.icao = ? " +
				"and f.arrivalAirport.icao = ? " +
				"and f.departureDate = ? " +
				"group by f.idFlight, p.seats.tariff");
		
		queryInnerJoin = queryInnerJoin.setParameter(0, departure);
		queryInnerJoin = queryInnerJoin.setParameter(1, arrival);
		queryInnerJoin = queryInnerJoin.setParameter(2, request.getParameter("dDate"));
		
		List result1 = queryInnerJoin.list();
		/////////////////////////////////////////////////////////////////////////////////////////////////

		List<Flight> flights = new ArrayList<Flight>();
		for (Object[] o : (List<Object[]>) result1) {
			Price p = (Price) o[0];
			Flight f = (Flight) o[1];
			flights.add(new Flight(f, p));
		}
		session.getTransaction().commit();
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
		System.out.println(request.getSession().getAttribute(RDATE));
		
		org.hibernate.Query queryFlyPrice =  session.createQuery(
				"from Price p inner join p.flight f " + 
				"where f.departureAirport.icao =? " + 
				"AND f.arrivalAirport.icao =? " +
				"AND f.departureDate =? "+ 
				"group by f.idFlight, p.seats.tariff");
		
		queryFlyPrice = queryFlyPrice.setParameter(0, departure);
		queryFlyPrice = queryFlyPrice.setParameter(1, arrival);
		queryFlyPrice = queryFlyPrice.setParameter(2, request.getSession().getAttribute(RDATE));
		
		List result = queryFlyPrice.list();
		
		List<Flight> flights = new ArrayList<Flight>();
		for (Object[] o : (List<Object[]>) result) {
			Price p = (Price) o[0];
			Flight f = (Flight) o[1];
			flights.add(new Flight(f, p));
		}
		session.getTransaction().commit();
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
}
