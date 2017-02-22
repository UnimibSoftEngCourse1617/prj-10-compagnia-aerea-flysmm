package frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Session;

import sale.Address;
import sale.Payment;
import servlets.SessionFactorySingleton;

public class PaymentCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("PaymentOptions")) {
			getPaymentMethodFromDB();
		}
		if (caller.equals("NewPayment")){
			addNewPaymentMethod();
		}
	}

	public void getPaymentMethodFromDB() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		Long idCustomer = Long.valueOf(request.getParameter("idCustomer"));

		org.hibernate.Query addressQuery = session.createQuery(
				"SELECT address " + 
				"FROM Customer c " + 
				"WHERE c.idCustomer =?"
				);
		addressQuery = addressQuery.setParameter(0, idCustomer);
		List resultAddress = addressQuery.list();

		
		org.hibernate.Query queryPayment = session.createQuery(
				"FROM Payment p " +
				"WHERE p.customer.idCustomer=? "
				);
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

	public void addNewPaymentMethod(){
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		

	}
}
