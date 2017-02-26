package frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import promotion.*;
import servlets.SessionFactorySingleton;

public class PromoCommand extends FrontCommand {
	private static final String SERVEXC = "An error occured";
	private static final Logger LOG = Logger.getLogger(PromoCommand.class);

	@Override
	public void dispatch() throws ServletException, IOException {
		if (("GP").equals(caller)) {
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
		request.setAttribute("type", request.getParameter("customertype"));
		RequestDispatcher dispatcher = context.getRequestDispatcher("/promotion.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			LOG.info(SERVEXC, e);
		} catch (IOException e) {
			LOG.info(SERVEXC, e);
		}
	}

}
