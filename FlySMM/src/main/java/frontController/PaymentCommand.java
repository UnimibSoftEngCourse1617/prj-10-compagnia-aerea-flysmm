package frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sale.Address;
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

		
		List result = session.createQuery("from Address where idAddress = 1").list();
		
		
		session.getTransaction().commit();
		
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		String json = gson.toJson((List<Address>) result);
		
		request.setAttribute("payment_method", (List<Address>) result);
		
		
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
