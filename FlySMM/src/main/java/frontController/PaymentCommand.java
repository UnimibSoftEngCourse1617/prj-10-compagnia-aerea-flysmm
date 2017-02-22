package frontController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.hibernate.Session;

import customer.Customer;
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
		
		Long idCustomer = Long.valueOf(request.getParameter("idCustomer"));
		
		
        //Add new Employee object
        Payment newPayment = new Payment();
        int nCard = Integer.parseInt(request.getParameter("NCard").toString());
        String ncvv = request.getParameter("cvv").toString();
        String nameOwner = request.getParameter("owner").toString();
        String expireString = request.getParameter("expiredDate");
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = (String) request.getSession().getAttribute(request.getParameter("expiredDate"));
		Date expire = null;
		try {
			expire = formatter.parse(dateInString);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        newPayment.setCardNumber(nCard);
        newPayment.setCustomer(customer);// ho bisogno del customer;
        newPayment.setCvv(ncvv);
        newPayment.setOwner(nameOwner);
        newPayment.setExpiredDate(expire);        
         
        //Save the employee in database
        session.save(newPayment);
 
        //Commit the transaction
        session.getTransaction().commit();

		org.hibernate.Query addressQuery = session.createQuery(
				"SELECT address " + 
				"FROM Customer c " + 
				"WHERE c.idCustomer =?"
				); 
		

	}
}
