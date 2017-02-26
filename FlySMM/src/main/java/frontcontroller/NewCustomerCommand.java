package frontcontroller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import customer.Customer;
import sale.Address;
import servlets.SessionFactorySingleton;

public class NewCustomerCommand extends FrontCommand {
	private static final String SERVEXC = "An error occured";
	private static final Logger LOG = Logger.getLogger(NewCustomerCommand.class);

	@Override
	public void dispatch() throws ServletException, IOException {
		if (("GNC").equals(caller)) {
			
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String email = request.getParameter("email");
			String via = request.getParameter("street");
			String ncivic = request.getParameter("Street_number");
			String cap = request.getParameter("cap");
			String city = request.getParameter("city");
			String country = request.getParameter("country");
			String psw = request.getParameter("password");
			String tel = request.getParameter("phoneNumber");
			String dataN = request.getParameter("dateOfBirth");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			try {
				startDate = sdf.parse(dataN);
				Address address = new Address(1,via,ncivic,cap,city,country);
				Customer c = new Customer(1, name, surname, address, email, psw, tel, startDate);
				writeAddress(address);					
				writeCustomer(c);
				RequestDispatcher dispatcher = context.getRequestDispatcher("/loginPage.html");
				dispatcher.forward(request, response);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				LOG.info(SERVEXC, e);
			}

		}
	}

	public static void writeCustomer(Customer c) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(c);
		session.getTransaction().commit();
	}
	public static void writeAddress(Address c) {
		Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		session.save(c);
		session.getTransaction().commit();
	}
	
}