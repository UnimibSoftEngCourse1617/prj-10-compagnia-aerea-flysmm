package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import frontController.FrontCommand;
import frontController.PaymentCommand;

/**
 * Servlet implementation class AddNewPaymentMethod
 */
public class AddNewPaymentMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(PaymentCommand.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewPaymentMethod() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FrontCommand command = null;
		try {
			command = FrontCommand.getCommand(request, response);
		} catch (Exception e) {
			LOG.error("An error occured", e);
		}
		if (command != null) {
			command.init(getServletContext(), "NewPayment", request, response);
			try {
				command.dispatch();
			} catch (Exception e){
				LOG.error("An error occured", e);
			}
		} else {
			System.out.println("CommandNotFound");
		}
	}

}
