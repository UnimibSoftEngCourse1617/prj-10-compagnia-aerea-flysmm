package frontController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		
		String arrival = resultFlight.get(0).getArrivalAirport().getIcao();
		String departure = resultFlight.get(0).getDepartureAirport().getIcao();
		String dateString = request.getParameter("newDate");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = dateString;
		Date date = null;
		
		try {
			date = formatter.parse(dateInString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		org.hibernate.Query queryInnerJoin = session.createQuery("from Price p inner join p.flight f "
				+ "where f.departureAirport.icao = ? " + "and f.arrivalAirport.icao = ? " + "and f.departureDate = ? "
				+ "and f.remainingSeats >= ? " + "group by f.idFlight, p.seats.tariff");

		System.out.println("date --> "+ date);
		queryInnerJoin = queryInnerJoin.setParameter(0, departure);
		queryInnerJoin = queryInnerJoin.setParameter(1, arrival);
		queryInnerJoin = queryInnerJoin.setDate(2, date);
		queryInnerJoin = queryInnerJoin.setParameter(3,1);
		List result1 = queryInnerJoin.list();
		
		System.out.println("queryInnerJoin --> " + result1.toString());
		if (result1.size() == 0) {
			String message = "Details: There are no flights matching search criteria. " + 
					"Go back to homepage and try to change date or airports.";
			request.setAttribute("message", message);
			try {
				context.getRequestDispatcher("/error.jsp").forward(request, response);
			} catch (Exception e) {
				
			}
		}

		List<Flight> flights = new ArrayList<Flight>();
		for (Object[] o : (List<Object[]>) result1) {
			Price p = (Price) o[0];
			p.setDiscountedAmount(p.getAmount());
			Flight f = (Flight) o[1];
			System.out.println(f.getRemainingSeats());
			Flight fp = new Flight(f, p);
			//checkforPromos(fp);
			flights.add(fp);
		}
		// session.getTransaction().commit();
		request.getSession().setAttribute("flights", flights);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/changeFly.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
