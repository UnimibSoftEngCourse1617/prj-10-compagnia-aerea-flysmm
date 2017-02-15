package customer;

import java.util.Date;

import org.hibernate.Session;
import servlets.SessionFactorySingleton;

public class inserimento {

	public static void main(String[] args) {
		Date data = new Date();
		// TODO Auto-generated method stub
		Customer c = new Customer(121, "luca", "lorusso", "dgs", "dgvs", "popo", data);
		Session session = SessionFactorySingleton.getSessionFactory().openSession();

		session.beginTransaction();

		c.setName(c.getName());
		c.setSurname(c.getSurname());

		session.save(c);
		session.getTransaction().commit();
	}

}
