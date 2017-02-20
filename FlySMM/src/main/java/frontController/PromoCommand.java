package frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Session;

import promotion.*;
import servlets.SessionFactorySingleton;

public class PromoCommand extends FrontCommand {

	@Override
	public void dispatch() throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (caller.equals("GP")) {
			getPromotionFromDb();
		}
	}
	
	public void getPromotionFromDb() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		session.beginTransaction();

		List result = session
				.createQuery("from Promotion")
				.list();

		session.getTransaction().commit();

		request.setAttribute("promotion", (List<Promotion>) result);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/promotion.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
