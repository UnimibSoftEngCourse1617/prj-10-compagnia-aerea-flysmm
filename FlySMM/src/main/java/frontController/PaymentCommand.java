package frontController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import booking.Book;
import customer.Customer;
import customer.FidelityCustomer;
import promotion.Mail;
import sale.Address;
import sale.Flight;
import sale.Payment;
import servlets.SessionFactorySingleton;

public class PaymentCommand extends FrontCommand {
	private static final Logger LOG = Logger.getLogger(PaymentCommand.class);

	@Override
	public void dispatch() throws ServletException, IOException {
		if ("PaymentOptions".equals(caller)) {
			getPaymentMethodFromDB();
		}
		if ("NewPayment".equals(caller)) {
			addNewPaymentMethod();
		}
		if ("MakePayment".equals(caller)) {
			makePayment();
		}
		if ("LastMinute".equals(caller)) {
			lastMinute();
		}

	}

	private void lastMinute() {
		// TODO Auto-generated method stub
		
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
			LOG.error("An error occured", e);
		} catch (IOException e) {
			LOG.error("An error occured", e);
		}
	}

	public void addNewPaymentMethod() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		Customer customer = (Customer) request.getSession().getAttribute("customer");

		Payment newPayment = new Payment();
		int nCard = Integer.parseInt(request.getParameter("NCard"));
		String ncvv = request.getParameter("cvv");
		String nameOwner = request.getParameter("owner");
		String expireString = request.getParameter("expiredDate");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date expire = null;
		try {
			expire = formatter.parse(expireString);
			System.out.println("SONO QUI");
		} catch (Exception e) {
			LOG.error("An error occured", e);
		}

		newPayment.setCardNumber(nCard);
		newPayment.setCustomer(customer);
		newPayment.setCvv(ncvv);
		newPayment.setOwner(nameOwner);
		newPayment.setExpiredDate(expire);

		session.save(newPayment);
		session.getTransaction().commit();

		RequestDispatcher dispatcher = context.getRequestDispatcher("/Payment_options");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			LOG.error("An error occured", e);
		} catch (IOException e) {
			LOG.error("An error occured", e);
		}
	}

	public void makePayment() {

		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		Customer customer = (Customer) request.getSession().getAttribute("customer");
		Long id = customer.getIdCustomer();

		org.hibernate.Query queryGetBook = session.createQuery("FROM Book b " + "WHERE b.customerId = ? ");
		queryGetBook.setParameter(0, customer.getIdCustomer());
		List<Book> resultGetBook = queryGetBook.list();

		org.hibernate.Query updateBook;

		for (int i = 0; i < resultGetBook.size(); i++) {
			updateBook = session.createQuery(
					"UPDATE Book " + "set Payed = 1 " + "where IdBook = '" + resultGetBook.get(i).getBookId() + "'");
			updateBook.executeUpdate();

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
			}

			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("yyyy-MM-dd");
			String dataStr = sdf.format(new Date());

			Query updatePoint = session.createQuery("UPDATE Customer " + "set point = " + sum + ", Date_last_book = '"
					+ dataStr + "' where idCustomer =" + id);
			updatePoint.executeUpdate();

			final Customer CUSTOMERRUN = (Customer) request.getSession().getAttribute("customer");

			Timer timer = new Timer();
			final List<Book> b = getBook();

			TimerTask task = new TimerTask() {

				@Override
				public void run() {
					((FidelityCustomer) CUSTOMERRUN).changeFidelity();
					for (Book book : b) {
						if (book.verifyExpired()) {
							if (book.verifyExpired()) {
								Mail m = new Mail();
								try {
									m.sendMail(CUSTOMERRUN.getEmail(),
											"il volo parte tra 24 ore! Paga la tua prenotazione!");
								} catch (MessagingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									LOG.error("An error occured", e);
								}

							}
						}
					}
				}
			};
			timer.schedule(task, 0, (1000 * 60 * 60 * 24));
			updateCustomer(CUSTOMERRUN);

		}

		session.getTransaction().commit();

		RequestDispatcher dispatcher = context.getRequestDispatcher("/GetBook?command=GetBook");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			LOG.error("An error occured", e);
		} catch (IOException e) {
			LOG.error("An error occured", e);
		}

	}

	public static void updateCustomer(Customer c) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}

	protected void tryPayment() throws Exception {
		// qui va messa l'implementazione del metodo per la chiamata al
		// sottosistema di pagamento

	}

	private List<Book> getBook() {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Book");
		List<Book> temp = (List<Book>) query.list();
		session.getTransaction().commit();
		return temp;
	}
}
