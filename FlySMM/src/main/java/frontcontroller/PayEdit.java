package frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import servlets.BookServlet;

/**
 * Servlet implementation class PayEdit
 */
@WebServlet("/PayEdit")
public class PayEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(BookServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayEdit() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doPost(request, response);
		} catch (Exception e) {
			LOG.error("An error in getCommand occured", e);
		}
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
			command.init(getServletContext(), "Update", request, response);
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
