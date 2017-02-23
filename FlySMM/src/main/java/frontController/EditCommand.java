package frontController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Query;
import org.hibernate.Session;

import booking.Book;
import sale.Flight;
import sale.Price;
import servlets.SessionFactorySingleton;

public class EditCommand extends FrontCommand{
	
	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("Edit")) {
			editBook();
		}
	}
	
	public void editBook (){
		
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		System.out.println("Id --> " + request.getSession().getAttribute("IDp"));
		Query getBook = session.createQuery(
				"From Book b "
				+ "Where b.bookId = ?"
				);
		
		getBook.setParameter(0, request.getSession().getAttribute("IDp"));
		List<Book> resultBook = getBook.list();
		System.out.println("Book : --> " + resultBook.toString());
		
		Query getFlight = session.createQuery(
				"from Flight f "
				+ "where f.idFlight = ?");
				
		getFlight.setParameter(0, resultBook.get(0).getFlightId());
		List<Flight> resultFlight = getFlight.list();
		System.out.println("Flight : --> " + resultFlight.toString());
		
//		org.hibernate.Query query = session.createQuery("Select icao from Airport " + "where name=?");
//
//		query = query.setParameter(0, request.getParameter("aDeparture"));
//		List result = query.list();
//		if (result.size() == 0) {
//			String message = "Details: There are no flights matching search criteria. " + 
//					"Go back to homepage and try to change date or airports.";
//			request.setAttribute("message", message);
//			try {
//				context.getRequestDispatcher("/error.jsp").forward(request, response);
//			} catch (Exception e) {
//				
//			}
//		}
//		String departure = (String) result.get(0);
//
//		org.hibernate.Query queryArrivalAirport = session.createQuery("Select icao from Airport " + "where name = ?");
//
//		queryArrivalAirport = queryArrivalAirport.setParameter(0, request.getParameter("aArrival"));
//		result = queryArrivalAirport.list();
//		if (result.size() == 0) {
//			String message = "Details: There are no flights matching search criteria. " + 
//					"Go back to homepage and try to change date or airports.";
//			request.setAttribute("message", message);
//			try {
//				context.getRequestDispatcher("/error.jsp").forward(request, response);
//			} catch (Exception e) {
//				
//			}
//		}
//		String arrival = (String) result.get(0);
//
//		request.getSession().setAttribute("aIcao", arrival);
//		request.getSession().setAttribute("dIcao", departure);
//
//		org.hibernate.Query queryInnerJoin = session.createQuery("from Price p inner join p.flight f "
//				+ "where f.departureAirport.icao = ? " + "and f.arrivalAirport.icao = ? " + "and f.departureDate = ? "
//				+ "and f.remainingSeats >= ? " + "group by f.idFlight, p.seats.tariff");
//
//		queryInnerJoin = queryInnerJoin.setParameter(0, departure);
//		queryInnerJoin = queryInnerJoin.setParameter(1, arrival);
//		queryInnerJoin = queryInnerJoin.setDate(2, parseStringToDate(DDATE));
//		queryInnerJoin = queryInnerJoin.setParameter(3,
//				Integer.parseInt((String) request.getSession().getAttribute("passengers")));
//
//		List result1 = queryInnerJoin.list();
//		if (result1.size() == 0) {
//			String message = "Details: There are no flights matching search criteria. " + 
//					"Go back to homepage and try to change date or airports.";
//			request.setAttribute("message", message);
//			try {
//				context.getRequestDispatcher("/error.jsp").forward(request, response);
//			} catch (Exception e) {
//				
//			}
//		}
//
//		List<Flight> flights = new ArrayList<Flight>();
//		for (Object[] o : (List<Object[]>) result1) {
//			Price p = (Price) o[0];
//			p.setDiscountedAmount(p.getAmount());
//			Flight f = (Flight) o[1];
//			System.out.println(f.getRemainingSeats());
//			Flight fp = new Flight(f, p);
//			checkforPromos(fp);
//			flights.add(fp);
//		}
//		// session.getTransaction().commit();
//		request.getSession().setAttribute("flights", flights);
//		RequestDispatcher dispatcher = context.getRequestDispatcher("/departure_flights.jsp");
//		try {
//			dispatcher.forward(request, response);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	

}
