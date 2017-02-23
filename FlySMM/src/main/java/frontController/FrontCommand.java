package frontController;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public abstract class FrontCommand {
	private static final Logger LOG =Logger.getLogger(FrontCommand.class);
	protected ServletContext context;
	protected String caller;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	

	public void init(ServletContext context, String caller, HttpServletRequest request, HttpServletResponse response) {
		this.context = context;
		this.caller = caller;
		this.request = request;
		this.response = response;
	}

	abstract public void dispatch() throws ServletException, IOException;
	
	public static FrontCommand getCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FrontCommand result = null;
		try {
			return (FrontCommand) getCommandClass(request, response).newInstance();
		} catch (Exception e) {
			request.getRequestDispatcher("./error.jsp").forward(request, response);
			LOG.error("An error occured", e);
		}
		return result;
	}

	private static Class getCommandClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Class result;
		final String commandClassName = "frontController." + (String) request.getParameter("command") + "Command";
		try {
			result = Class.forName(commandClassName);
		} catch (ClassNotFoundException e) {
			result = UnknownCommand.class;
			request.getRequestDispatcher("./error.jsp").forward(request, response);
			LOG.error("An error occured", e);
		}
		return result;
	}

}
