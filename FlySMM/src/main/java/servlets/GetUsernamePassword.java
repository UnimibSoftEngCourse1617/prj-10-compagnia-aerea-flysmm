package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import frontcontroller.FrontCommand;

public class GetUsernamePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(GetUsernamePassword.class);
	
	public GetUsernamePassword() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Empty because useless
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FrontCommand command = null;
		try {
			command = FrontCommand.getCommand(request, response);
		} catch (Exception e1) {
			LOG.error("An error in getCommand occured", e1);
		}

		if (command != null) {

			command.init(getServletContext(), "GUP", request, response);
			
			try {
				command.dispatch();
			} catch (Exception e2) {
				LOG.error("An error in dispatch occured", e2);
				}


		} else {
			System.out.println("CommandNotFound");
		}
	}

}
