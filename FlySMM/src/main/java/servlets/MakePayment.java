package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import frontController.FrontCommand;

/**
 * Servlet implementation class MakePayment
 */
public class MakePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(MakePayment.class);
       
    public MakePayment() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Empty because useless
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FrontCommand command = null;
		try {
			command = FrontCommand.getCommand(request, response);
		} catch (Exception e) {
			LOG.error("An error occured", e);
		}
		if (command != null) {
			command.init(getServletContext(), "MakePayment", request, response);
			try {
				command.dispatch();
			} catch (Exception e) {
				LOG.error("An error occured", e);
			}
		} else {
			System.out.println("CommandNotFound");
		}
	}
}
