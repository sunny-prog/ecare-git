package servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.FrontCommand;
import command.UnknownCommand;

public class FrontServlet extends HttpServlet {

	/** id for serialization */
	private static final long serialVersionUID = -6317133308652501279L;

	@Override
	public void init(final ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		FrontCommand command = getCommand(request);
		command.init(getServletContext(), request, response);
		command.execute();
	}

	private FrontCommand getCommand(HttpServletRequest request) {
		try {
			return (FrontCommand) getCommandClass(request).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	private Class getCommandClass(HttpServletRequest request) {

		Class result;
		Pattern pattern = Pattern.compile("/StudyWebApp/views/(\\w+).go.*");
		Matcher matcher = pattern.matcher(request.getRequestURI());

		final String commandClassName = "command."
				+ (matcher.find() ? matcher.group(1) : "") + "Command";

		// final String commandClassName = "command." +
		// request.getParameter("command") + "Command";
		try {
			result = Class.forName(commandClassName);
		} catch (ClassNotFoundException e) {
			result = UnknownCommand.class;
		}

		return result;
	}

}
