package frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sale.Address;
import sale.Payment;
import servlets.HibernateProxyTypeAdapter;
import servlets.SessionFactorySingleton;

public class PaymentCommand extends FrontCommand {
	
	
	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("GDF")) {
			getPaymentMethodFromDB();
		}
	}

	public void getPaymentMethodFromDB() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		
		String idCustomer = request.getParameter("idCustomer").toString();
		
		// --> funziona
		List resultAddress = session.createQuery("select address from Customer c where c.idCustomer="+ idCustomer).list();
		// <-- funziona
		
		List resultPayment = session.createQuery("from Payment p where p.customer.idCustomer="+ idCustomer).list();
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
}
