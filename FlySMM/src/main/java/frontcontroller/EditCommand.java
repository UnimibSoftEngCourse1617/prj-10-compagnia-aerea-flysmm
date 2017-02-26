package frontcontroller;

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
	private static final String ERROR = "An error occured";
	private static final String OLDBOOK = "oldBook";
	private static final String CUSTOMER = "customer";

	@Override
	public void dispatch() throws ServletException, IOException {

		if (("Edit").equals(caller)) {
			editBook();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/changeFly.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				LOG.error(ERROR, e);
			} catch (IOException e) {
				LOG.error(ERROR, e);
			}
		}
		if ("Increase".equals(caller)) {
			computeIncrease();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/confirm.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				LOG.error(ERROR, e);
			} catch (IOException e) {
				LOG.error(ERROR, e);
			}
		}

		if (("Update").equals(caller)) {
			if (updateBook()) {
				RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
				try {
					dispatcher.forward(request, response);
				} catch (ServletException e) {
					LOG.error(ERROR, e);
				} catch (IOException e) {
					LOG.error(ERROR, e);
				}
			} else { // TODO: questo dispatcher va cambiato ci troviamo nel caso
						// in cui il pagamento non è andato a buonfine
				RequestDispatcher dispatcher = context.getRequestDispatcher("/error.jsp");
				try {
					dispatcher.forward(request, response);
				} catch (ServletException e) {
					LOG.error(ERROR, e);
				} catch (IOException e) {
					LOG.error(ERROR, e);
				}
			}

		}

	}

	public void editBook() {


		/**
		 * INIZIALIZZO LA SESSIONE
		 */
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		/** INIZIO DEL SETTAGGIO DEI VALORI NECCESSARI PER L'EDIT */

		/**
		 * la sezione è stata inizializzata
		 */

		/**
		 * Creo la query che estrae l'oggetto vecchia prenotazione
		 */
		Query getBook = session.createQuery("From Book b Where b.bookId = ?");
		getBook.setParameter(0, request.getSession().getAttribute("IDp"));
		List<Book> resultOldBook = getBook.list();
		request.getSession().setAttribute(OLDBOOK, resultOldBook.get(0));

		/**
		 * set in parametro di sezione del oggetto vecchio Book
		 */


		/**
		 * qui estraggo tutte le informazioni relative al vecchio volo
		 */
		Query getOldFlight = session.createQuery("from Flight f " + "where f.idFlight = ?");
		getOldFlight.setParameter(0, resultOldBook.get(0).getFlightId());
		List<Flight> resultOldFlight = getOldFlight.list();

		request.getSession().setAttribute("oldFlight", resultOldFlight.get(0));
		/**
		 * questa query è necessaria per ottenere il volo vecchio e il relativo
		 * prezzo
		 */

		long idCustomer = resultOldBook.get(0).getCustomerId();

		Query getCustomer = session.createQuery("from Customer c " + "where c.idCustomer = ?  ");

		getCustomer.setParameter(0, idCustomer);
		Customer customer = (Customer) getCustomer.list().get(0);
		request.getSession().setAttribute(CUSTOMER, customer);

		/** FINE DEL SETTAGGIO DEI VALORI NECCESSARI PER L'EDIT */

		/** INIZIO PARTE VISUALLIZZAZIONE DEI VOLI SCELTI PER LA MODIFICA */

		String departure = resultOldFlight.get(0).getDepartureAirport().getIcao();
		String arrival = resultOldFlight.get(0).getArrivalAirport().getIcao();
		String dateString = request.getParameter("newDate");

		org.hibernate.Query queryInnerJoin = session.createQuery("from Price p inner join p.flight f "
				+ "where f.departureAirport.icao = ? " + "and f.arrivalAirport.icao = ? " + "and f.departureDate = ? "
				+ "and f.remainingSeats >= ? " + "group by f.idFlight, p.seats.tariff");

		queryInnerJoin = queryInnerJoin.setParameter(0, departure);
		queryInnerJoin = queryInnerJoin.setParameter(1, arrival);
		queryInnerJoin = queryInnerJoin.setDate(2, parseStringToDate(dateString));
		queryInnerJoin = queryInnerJoin.setParameter(3, 1);

		List result1 = queryInnerJoin.list();
		if (result1.isEmpty()) {
			String message = "Details: There are no flights matching search criteria. "
					+ "Go back to homepage and try to change date or airports.";
			request.setAttribute("message", message);
			try {
				context.getRequestDispatcher("/error.jsp").forward(request, response);
			} catch (Exception e) {
				LOG.error("An error occured", e);
			}
		}

		ArrayList<Flight> flights = new ArrayList<Flight>();
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

		/** FINE PARTE VISUALLIZZAZIONE DEI VOLI SCELTI PER LA MODIFICA */
	}

	public void computeIncrease() {

		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		String[] flight = request.getParameter("chosen").split("-");
		String idNewFlight = flight[0];

		/* salvo il nuovo volo in una variabile di sessione */
		Query queryNewFlight = session.createQuery("from Flight f " + "where f.idFlight = :idF ");
		queryNewFlight.setParameter("idF", idNewFlight);
		List<Flight> newFlight = queryNewFlight.list();
		request.getSession().setAttribute("newFlight", newFlight);

		
		Book oldBook = (Book) request.getSession().getAttribute(OLDBOOK);

		float debit = oldBook.getTotalPrice() * 0.08f;
		
		request.getSession().setAttribute("debit", debit);

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

	public boolean updateBook() {
		Customer c = (Customer) request.getSession().getAttribute(CUSTOMER);
		request.getSession().removeAttribute(CUSTOMER);
		request.getSession().setAttribute(CUSTOMER, c);
		
		float debit = (Float) request.getSession().getAttribute("debit");
		PaymentCommand p = new PaymentCommand(c);
				
		boolean status = false;
		if (debit > 0) {
			try {
				status = p.authorizePayment(debit);
			} catch (Exception e) {
				LOG.info("Error in autorizePayment", e);
			}
		}
		
		if (status) {
			// bisogna aggiornare i posti togliere e aggiungere
			Session session = SessionFactorySingleton.getSessionFactory().openSession();
			session.beginTransaction();

			// un po' di questa roba va giù
			Flight oldFlight = (Flight) request.getSession().getAttribute("oldFlight");
			String idOldFlight = oldFlight.getIdFlight();

			Book oldBook = (Book) request.getSession().getAttribute(OLDBOOK);
			long idCustomer = oldBook.getCustomerId();
			String idBook = oldBook.getBookId();

			Customer customer = (customer.Customer) request.getSession().getAttribute(CUSTOMER);


			List<Flight> newFlight = (List) request.getSession().getAttribute("newFlight");
			String idNewFlight = newFlight.get(0).getIdFlight();

			// authorizePayment();

			if (customer instanceof FidelityCustomer) {

				int distance = oldFlight.getDistance();
				int oldPoint = ((FidelityCustomer) customer).getPoint();
				int newPoint = (oldPoint - distance) + ((Flight) newFlight.get(0)).getDistance();

				Query updateNewBook = session.createQuery("UPDATE Customer " + "set point = :newPoint , "
						+ "Date_last_book = :dataStr " + "where idCustomer = :id");

				SimpleDateFormat sdf = new SimpleDateFormat();
				sdf.applyPattern("yyyy-MM-dd");
				String dataStr = sdf.format(new Date());

				updateNewBook.setParameter("newPoint", newPoint);
				updateNewBook.setDate("dataStr", parseStringToDate(dataStr));
				updateNewBook.setParameter("id", idCustomer);

				updateNewBook.executeUpdate();
				System.out.println("Sono qui: " + newPoint);
			}

			// aggiungere e togliere un posto
			int oldFlightNSeats = oldFlight.getRemainingSeats() + 1;
			int newFlightNSeats = ((Flight) newFlight.get(0)).getRemainingSeats() - 1;

			Query updateFlightSeats = session.createQuery(
					"UPDATE Flight f " + "set f.remainingSeats = :seatNumber " + "where f.idFlight = :idF");

			updateFlightSeats.setParameter("seatNumber", oldFlightNSeats);
			updateFlightSeats.setParameter("idF", idOldFlight);
			updateFlightSeats.executeUpdate();

			updateFlightSeats.setParameter("seatNumber", newFlightNSeats);
			updateFlightSeats.setParameter("idF", idNewFlight);
			updateFlightSeats.executeUpdate();

			Query updateBook = session.createQuery(
					"Update Book " + "set Flight_Flight_ID = :newFlightId, " + "Booking_date = :newBookDate, "
							+ "Flight_Departure_Date = :newDepartureDate " + "where bookId = :bookId");

			updateBook.setParameter("newFlightId", idNewFlight);

			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("yyyy-MM-dd");
			String dataStr = sdf.format(new Date());

			updateBook.setDate("newBookDate", parseStringToDate(dataStr));
			updateBook.setDate("newDepartureDate", newFlight.get(0).getDepartureDate());
			updateBook.setParameter("bookId", idBook);
			updateBook.executeUpdate();
			session.getTransaction().commit();
			
		}
		return status;
	}

	public Date parseStringToDate(String dateString) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = dateString;
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (Exception e) {
			LOG.info("Error during date parsing", e);
		}
		return date;
	}
}
