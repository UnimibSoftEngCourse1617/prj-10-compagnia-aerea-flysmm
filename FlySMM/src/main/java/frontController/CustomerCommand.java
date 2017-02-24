package frontController;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import customer.Customer;
import customer.FidelityCustomer;
import servlets.SessionFactorySingleton;

public class CustomerCommand extends FrontCommand {
	private static final String SERVEXC = "An error occured";
	private static final Logger LOG = Logger.getLogger(PromoCommand.class);

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("GDF")) {
			getCustomerFromDb();
		}
	}

	public void getCustomerFromDb() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		Customer customerRegistry = null;
		try {
			List result = session.createQuery("from Customer " + "where email = '" + request.getParameter("email") + "'"
					+ " and password = '" + request.getParameter("psw") + "'").list();

			if (result.size() == 1) {

				customerRegistry = (Customer) result.get(0);

				request.getSession().setAttribute("customer", customerRegistry);

				request.getSession().setAttribute("idCustomer", customerRegistry.getIdCustomer());
				request.getSession().setAttribute("Customer", customerRegistry);
				RequestDispatcher dispatcher;
				if (request.getSession().getAttribute("chosenDeparture") == null) {
					if (customerRegistry.getClass().toString().matches("class customer.FidelityCustomer")) {
						dispatcher = context.getRequestDispatcher("/homeFidelityCustomer.jsp");
					} else {
						dispatcher = context.getRequestDispatcher("/homeCustomer.jsp");
					}
				} else
					dispatcher = context.getRequestDispatcher("/addPassenger.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = context.getRequestDispatcher("/loginPage.html");
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(dialog, "The email or password are wrong! Retry!");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			LOG.info(SERVEXC, e);
		}

	}

}
