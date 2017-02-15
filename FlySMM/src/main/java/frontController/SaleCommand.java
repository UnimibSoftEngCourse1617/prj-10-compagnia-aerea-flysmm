package frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.Query;
import org.hibernate.Session;

import sale.Airport;
import servlets.SessionFactorySingleton;

public class SaleCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {
		if (caller.equals("GDF")) {
			getFlightFromDb();
		}
	}

	public void getFlightFromDb() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();
		List result = session.createQuery("from Airport").list();
		for (Airport airport : (List<Airport>) result) {
			System.out.println(airport.toString());
		}
		session.getTransaction().commit();
		session.close();
	}

}
