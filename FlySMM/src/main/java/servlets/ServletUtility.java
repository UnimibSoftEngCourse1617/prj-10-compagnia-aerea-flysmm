package servlets;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import frontcontroller.FrontCommand;

public class ServletUtility {
	
	private static final Logger LOG = Logger.getLogger(ServletUtility.class);

	public static void initAndDispatch(ServletContext context, HttpServletRequest request, HttpServletResponse response,
			String caller) {
		FrontCommand command = null;
		try {
			command = FrontCommand.getCommand(request, response);
		} catch (Exception e) {
			LOG.error("An error occured", e);
		}
		if (command != null) {
			command.init(context, caller, request, response);
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
