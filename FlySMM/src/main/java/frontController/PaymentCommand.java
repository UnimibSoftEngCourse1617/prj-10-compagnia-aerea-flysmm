package frontController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Query;
import org.hibernate.Session;

import booking.Book;
import customer.Customer;
import customer.FidelityCustomer;
import sale.Address;
import sale.Flight;
import sale.Payment;
import servlets.SessionFactorySingleton;

public class PaymentCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("PaymentOptions")) {
			getPaymentMethodFromDB();
		}
		if (caller.equals("NewPayment")) {
			addNewPaymentMethod();
		}
		if (caller.equals("MakePayment")) {
			makePayment();
		}

	}

	public void getPaymentMethodFromDB() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		Customer customer = (Customer) request.getSession().getAttribute("customer");
		Long idCustomer = customer.getIdCustomer();

		org.hibernate.Query addressQuery = session
				.createQuery("SELECT address " + "FROM Customer c " + "WHERE c.idCustomer =?");
		addressQuery = addressQuery.setParameter(0, idCustomer);
		List resultAddress = addressQuery.list();

		org.hibernate.Query queryPayment = session.createQuery("FROM Payment p " + "WHERE p.customer.idCustomer=? ");
		queryPayment = queryPayment.setParameter(0, idCustomer);
		List resultPayment = queryPayment.list();

		session.getTransaction().commit();

		request.setAttribute("address", (List<Address>) resultAddress);
		request.setAttribute("payment", (List<Payment>) resultPayment);

		RequestDispatcher dispatcher = context.getRequestDispatcher("/payment_methods.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addNewPaymentMethod() throws ServletException, IOException {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		Customer customer = (Customer) request.getSession().getAttribute("customer");
		Long idCustomer = customer.getIdCustomer();

		Payment newPayment = new Payment();
		int nCard = Integer.parseInt(request.getParameter("NCard").toString());
		String ncvv = request.getParameter("cvv").toString();
		String nameOwner = request.getParameter("owner").toString();
		String expireString = request.getParameter("expiredDate");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date expire = null;
		try {
			expire = formatter.parse(expireString);
			System.out.println("SONO QUI");
		} catch (Exception e) {
			e.printStackTrace();
		}

		newPayment.setCardNumber(nCard);
		newPayment.setCustomer(customer);
		newPayment.setCvv(ncvv);
		newPayment.setOwner(nameOwner);
		newPayment.setExpiredDate(expire);

		session.save(newPayment);
		session.getTransaction().commit();

		RequestDispatcher dispatcher = context.getRequestDispatcher("/Payment_options");
		dispatcher.forward(request, response);
	}

	public void makePayment() {

		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		Customer customer = (Customer) request.getSession().getAttribute("customer");
		Long id = customer.getIdCustomer();
		System.out.println("questo è il mio customer --> " + customer.toString());

		org.hibernate.Query queryGetBook = session.createQuery("FROM Book b " + "WHERE b.customerId = ? ");
		queryGetBook.setParameter(0, customer.getIdCustomer());
		List<Book> resultGetBook = queryGetBook.list();

		System.out.println("resultGetBook --> " + resultGetBook.get(0).toString());
		org.hibernate.Query updateBook;

		for (int i = 0; i < resultGetBook.size(); i++) {
			updateBook = session.createQuery(
					"UPDATE Book " + "set Payed = 1 " + "where IdBook = '" + resultGetBook.get(i).getBookId() + "'");
			updateBook.executeUpdate();

			
			System.out.println("La query di book -->  " + resultGetBook.get(i).getBookId());
		}
		

		if (customer instanceof FidelityCustomer) {
			
			// devo beccare i punti che ha gia
			int sum = ((FidelityCustomer) customer).getPoint();
			org.hibernate.Query queryFlight;
			List<Flight> resultFlight;
			for (Book book : resultGetBook) {
				String flight = book.getFlightId();

				queryFlight = session.createQuery("FROM Flight f " + "WHERE f.idFlight=? ");
				queryFlight.setParameter(0, flight);
				resultFlight = queryFlight.list();

				int point = resultFlight.get(0).getDistance();
				sum = sum + point;
				System.out.println("il punteggio parziale è: --> " + sum);
			}
			
			GregorianCalendar date = new GregorianCalendar();
			
			Query updatePoint = session.createQuery("UPDATE Customer " + "set point = " + sum + ", Date_last_book = "+ date.getTime() +" where idCustomer =" + id);
			updatePoint.executeUpdate();
	
			session.save(customer);
		}
		
		session.getTransaction().commit();

	}

	protected void tryPayment() throws Exception {
		// qui va messo l'implementazione del metodo per la chiamata al
		// sottosistema di pagamento
	}
}
