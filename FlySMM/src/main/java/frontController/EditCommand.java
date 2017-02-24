package frontController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hamcrest.core.IsInstanceOf;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.logging.Logger;

import booking.Book;
import customer.Customer;
import customer.FidelityCustomer;
import sale.Flight;
import sale.Price;
import servlets.SessionFactorySingleton;

public class EditCommand extends FrontCommand {

	
	private static final Logger LOG = Logger.getLogger(EditCommand.class);

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("Edit")) {
			editBook();
		}
		if (caller.equals("Update")) {
			updateBook();
		}
		if (caller.equals("Increase")) {
			increaseBook();
		}

	}

	public void editBook() {
		/**
		 * metodo edit book
		 * questo metodo si occupera di settare tutti gli attributi nessesari per procedere alla modifica di una prenotazione,
		 * inoltre farà una dispatch alla jsp che esporrà i voli diponibili per il cambio
		 * */
		
		/**
		 * in input abbiamo il id del veccio book */
		
		/**
		 * INIZIALIZZO LA SESSIONE
		 * */
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		
		/** INIZIO DEL SETTAGGIO DEI VALORI NECCESSARI PER L'EDIT */
		
		/**
		 * la sezione è stata inizializzata*/
		
		/**Ottengo il id della vecchia prenotazione*/
		System.out.println("Id --> " + request.getSession().getAttribute("IDp"));
		
		/** 
		 * Creo la query che estrae l'oggetto vicchia prenotazione
		 * */
		Query getBook = session.createQuery("From Book b Where b.bookId = ?");
		getBook.setParameter(0, request.getSession().getAttribute("IDp"));
		List<Book> resultBook = getBook.list();
		System.out.println("Book : --> " + resultBook.toString());
		request.getSession().setAttribute("oldBook", resultBook);
		
		/**
		 * set in parametro di sezione del oggetto vecchio Book 
		 * */

		//////////////////////////////////////////////////////////////////////////
		
		/**
		 * qui estraggo tutte le informazioni relative al vecchio volo 
		 * */
		Query getOldFlight = session.createQuery("from Flight f " + "where f.idFlight = ?");
		getOldFlight.setParameter(0, resultBook.get(0).getFlightId());
		List<Flight> resultOldFlight = getOldFlight.list();
		
		//////////////////////////////////////////////////////////////////////////
		/** questa query è necessaria per ottenere il volo vecchio e il relativo prezzo */
		
		Query queryInnerJoin = session.createQuery("from Price p inner join p.flight f "
				+ "where f.departureAirport.icao = ? " + "and f.arrivalAirport.icao = ? " 
				+ "and f.departureDate = ? "
				+ "and f.remainingSeats >= ? " 
				+ "group by f.idFlight, p.seats.tariff");
		
		String arrival = resultOldFlight.get(0).getArrivalAirport().getIcao();
		String departure = resultOldFlight.get(0).getDepartureAirport().getIcao();
		Date oldDate = resultOldFlight.get(0).getDepartureDate();
		
		queryInnerJoin = queryInnerJoin.setParameter(0, departure);
		queryInnerJoin = queryInnerJoin.setParameter(1, arrival);
		queryInnerJoin = queryInnerJoin.setDate(2, oldDate);
		queryInnerJoin = queryInnerJoin.setParameter(3, 1);
		List resultGOFWP = queryInnerJoin.list();

		//////////////////////////////////////////////////////////////////////////
		/** creo l'oggetto flights e assoccio il prezzo */
		List<Flight> flights = new ArrayList<Flight>();
		for (Object[] o : (List<Object[]>) resultGOFWP) {
			Price p = (Price) o[0];
			p.setDiscountedAmount(p.getAmount());
			Flight f = (Flight) o[1];
			System.out.println(f.getRemainingSeats());
			Flight fp = new Flight(f, p);
			checkforPromos(fp);
			flights.add(fp);
		}
		
		request.getSession().setAttribute("oldFlight", flights);
		
		/** FINE DEL SETTAGGIO DEI VALORI NECCESSARI PER L'EDIT */
		
		
		
		
		
		System.out.println("il valore di olf Flight --> " + flights.get(0).toString());
		System.out.println("il valore di old Flight price --> " + flights.get(0).getPrice().toString());
		
		
		List<Book> oldBook = (List<Book>) request.getSession().getAttribute("oldBook");
		long idCustomer = oldBook.get(0).getCustomerId();
		String idBook = oldBook.get(0).getBookId();

		//////////////////////////////////////////////////////////////////////////
		Query getCustomer = session.createQuery("from Customer c " + "where c.idCustomer = ?  ");

		getCustomer.setParameter(0, idCustomer);
		Customer customer = (Customer) getCustomer.list().get(0);
		request.getSession().setAttribute("customer", customer);
		System.out.println("il book di update book --> " + customer.toString());

		//////////////////////////////////////////////////////////////////////////

//		System.out.println("date --> " + date);
		queryInnerJoin = queryInnerJoin.setParameter(0, departure);
		queryInnerJoin = queryInnerJoin.setParameter(1, arrival);
//		queryInnerJoin = queryInnerJoin.setDate(2, date);
		queryInnerJoin = queryInnerJoin.setParameter(3, 1);
		List result1 = queryInnerJoin.list();

		System.out.println("queryInnerJoin --> " + result1.toString());
		if (result1.size() == 0) {
			String message = "Details: There are no flights matching search criteria. "
					+ "Go back to homepage and try to change date or airports.";
			request.setAttribute("message", message);
			try {
				context.getRequestDispatcher("/error.jsp").forward(request, response);
			} catch (Exception e) {

			}
		}

		flights = new ArrayList<Flight>();
		for (Object[] o : (List<Object[]>) result1) {
			Price p = (Price) o[0];
			p.setDiscountedAmount(p.getAmount());
			Flight f = (Flight) o[1];
			System.out.println(f.getRemainingSeats());
			Flight fp = new Flight(f, p);
			checkforPromos(fp);
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

	public void updateBook() {
		// pbisogna aggiornare i posti togliere e aggiungere
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		List<Flight> oldFlight = (List<Flight>) request.getSession().getAttribute("oldFlight");
		String idOldFlight = oldFlight.get(0).getIdFlight();

		List<Book> oldBook = (List<Book>) request.getSession().getAttribute("oldBook");
		long idCustomer = oldBook.get(0).getCustomerId();
		String idBook = oldBook.get(0).getBookId();

		Customer customer = (customer.Customer) request.getSession().getAttribute("customer");

		System.out.println("il book di update book --> " + customer.toString());

		String[] flight = request.getParameter("chosen").split("-");
		String idNewFlight = flight[0];

		Query queryNewFlight = session.createQuery("from Flight f " + "where f.idFlight = :idF ");

		queryNewFlight.setParameter("idF", idNewFlight);
		List<Flight> newFlight = queryNewFlight.list();

		System.out.println("Sono qui: " + idNewFlight);

		if (customer instanceof FidelityCustomer) {

			int distance = oldFlight.get(0).getDistance();
			int oldPoint = ((FidelityCustomer) customer).getPoint();
			int newPoint = (oldPoint - distance) + newFlight.get(0).getDistance();

			Query updateNewBook = session.createQuery("UPDATE Customer " + "set point = :sum , "
					+ "Date_last_book = :dataStr " + "where idCustomer = :id");

			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("yyyy-MM-dd");
			String dataStr = sdf.format(new Date());

			updateNewBook.setParameter("sum", newPoint);
			updateNewBook.setParameter("dataStr", dataStr);
			updateNewBook.setParameter("id", idCustomer);

			updateNewBook.executeUpdate();
			System.out.println("Sono qui: " + newPoint);
		}

		// aggiungere e togliere un posto
		int oldFlightNSeats = oldFlight.get(0).getRemainingSeats() + 1;
		int newFlightNSeats = oldFlight.get(0).getRemainingSeats() - 1;

		Query updateFlightSeats = session
				.createQuery("UPDATE Flight f " + "set f.remainingSeats = :seatNumber " + "where f.idFlight = :idF");

		updateFlightSeats.setParameter("seatNumber", oldFlightNSeats);
		updateFlightSeats.setParameter("idF", idOldFlight);
		updateFlightSeats.executeUpdate();

		System.out.println("Sono qui: " + oldFlightNSeats);

		updateFlightSeats.setParameter("seatNumber", newFlightNSeats);
		updateFlightSeats.setParameter("idF", idNewFlight);
		updateFlightSeats.executeUpdate();

		System.out.println("Sono qui: " + newFlightNSeats);

		Query updateBook = session.createQuery("Update Book " + "set Flight_Flight_ID = :newFlightId, "
				+ "Booking_date = :newBookDate, " + "Flight_Departure_Date = :newDepartureDate");

		updateBook.setParameter("newFlightId", idNewFlight);

		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		String dataStr = sdf.format(new Date());

		updateBook.setParameter("newBookDate", dataStr);
		updateBook.setParameter("newDepartureDate", newFlight.get(0).getDepartureDate());
		updateBook.executeUpdate();

		System.out.println("sono qui: " + updateBook.toString());
	}

	public void increaseBook() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("sono in increase");
		Customer customer = (customer.Customer) request.getSession().getAttribute("customer");
		long idCustomer = customer.getIdCustomer();

		Flight oldFlight = (Flight) request.getSession().getAttribute("oldFlight");

		String newPriceString = null;
		float oldPrice = 0f;

		if (customer instanceof FidelityCustomer) {
			// differenza scontata
			newPriceString = request.getParameter("discounted");
			oldPrice = oldFlight.getPrice().getDiscountedAmount();
		} else {
			newPriceString = request.getParameter("amount");
			oldPrice = oldFlight.getPrice().getAmount();
		}

		float newPrice = Float.parseFloat(newPriceString);
		float diff = newPrice - oldPrice;

		if (diff > 0) {
			// caso in cui c'è da pagare
			updateBook();
			System.out.println("sono nel ramo sbagliato");
		} else {
			updateBook();
			System.out.println("Ho finito ora spaccio ");
			try {
				context.getRequestDispatcher("./GetBook").forward(request, response);
			} catch (ServletException e) {
				LOG.error("An error occured", e);
			} catch (IOException e) {
				LOG.error("An error occured", e);
			}
		}
	}
	
}
