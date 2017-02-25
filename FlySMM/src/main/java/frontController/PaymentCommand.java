package frontController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import sale.Payment_methods;
import servlets.SessionFactorySingleton;

//import java.util.List;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import com.paypal.api.payments.Amount;
//import com.paypal.api.payments.Details;
//import com.paypal.api.payments.Links;
//import com.paypal.api.payments.Payer;
//import com.paypal.api.payments.Payment;
//import com.paypal.api.payments.PaymentExecution;
//import com.paypal.api.payments.RedirectUrls;
//import com.paypal.api.payments.Transaction;

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
		request.setAttribute("payment", (List<Payment_methods>) resultPayment);

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

		Payment_methods newPayment = new Payment_methods();
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

	public void makePayment() throws ServletException, IOException {

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

		}

		session.getTransaction().commit();

		RequestDispatcher dispatcher = context.getRequestDispatcher("/GetBook?command=GetBook");
		dispatcher.forward(request, response);

	}

	private boolean authorizePayment(float amount) throws Exception {



//		// Set payer details
//		Payer payer = new Payer();
//		payer.setPaymentMethod("paypal");
//
//		// Set redirect URLs
//		RedirectUrls redirectUrls = new RedirectUrls();
//		redirectUrls.setCancelUrl("http://localhost:3000/cancel");
//		redirectUrls.setReturnUrl("http://localhost:3000/process");
//
//		// Set payment details
//		Details details = new Details();
//		details.setShipping("0");
//		details.setSubtotal(amount);
//		details.setTax("0");
//
//		// Payment amount
//		Amount amount = new Amount();
//		amount.setCurrency("EUR");
//		// Total must be equal to sum of shipping, tax and subtotal.
//		amount.setTotal(amount);
//		amount.setDetails(details);
//
//		// Transaction information
//		Transaction transaction = new Transaction();
//		transaction.setAmount(amount);
//		transaction
//		  .setDescription("This is the payment transaction description.");
//
//		// Add transaction to a list
//		List<Transaction> transactions = new ArrayList<Transaction>();
//		transactions.add(transaction);
//
//		// Add payment details
//		Payment payment = new Payment();
//		payment.setIntent("sale");
//		payment.setPayer(payer);
//		payment.setRedirectUrls(redirectUrls);
//		payment.setTransactions(transactions);
//		
//		
//		// Create payment
//		try {
//		  Payment createdPayment = payment.create(apiContext);
//
//		  Iterator links = createdPayment.getLinks().iterator();
//		  while (links.hasNext()) {
//		    Links link = links.next();
//		    if (link.getRel().equalsIgnoreCase("approval_url")) {
//		      // REDIRECT USER TO link.getHref()
//		    }
//		  }
//		} catch (PayPalRESTException e) {
//		    System.err.println(e.getDetails());
//		}
//		
//		Payment payment = new Payment();
//		payment.setId(req.getParameter("paymentId"));
//
//		PaymentExecution paymentExecution = new PaymentExecution();
//		paymentExecution.setPayerId(req.getParameter("PayerID"));
//		try {
//		  Payment createdPayment = payment.execute(apiContext, paymentExecution);
//		  System.out.println(createdPayment);
//		} catch (PayPalRESTException e) {
//		  System.err.println(e.getDetails());
//		}
//		
//		PaymentExecution paymentExecution = new PaymentExecution();
//		paymentExecution.setPayerId(req.getParameter("PayerID"));
//		try {
//			Payment_methods createdPayment = payment.execute(apiContext, paymentExecution);
//			System.out.println(createdPayment);
//		} catch (PayPalRESTException e) {
//			System.err.println(e.getDetails());
//		}

	}
}
