package frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import promotion.SeasonPromotion;
import servlets.HibernateProxyTypeAdapter;
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
				.createQuery("from SeasonPromotion")
				.list();
		//String season = (String) result.get(0);

		/*result = session
				.createQuery("from Promotion " + "where promo_type = 'flight'")
				.list();
		String flight = (String) result.get(0);*/

		session.getTransaction().commit();
		
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		String json = gson.toJson((List<SeasonPromotion>) result);
		request.setAttribute("promotions", (List<SeasonPromotion>) result);
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
