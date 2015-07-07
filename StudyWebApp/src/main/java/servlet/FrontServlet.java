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

/**
 * Provides a centralized entry point for handling requests. Parses incoming command in URL.
 * Instantiates needed command entity, run it's <code>init()</code> and <code>execute()</code> methods.
 *
 * @author Tatiana
 * @version 1.0
 */
public class FrontServlet extends HttpServlet {
    /**
     * id for serialization.
     */
    private static final long serialVersionUID = -6317133308652501279L;

    @Override
    public final void init(final ServletConfig conf) throws ServletException {
        super.init(conf);
    }

    /**
     * Called by the server (via the service method) to allow a servlet to handle a GET request.
     *
     * @param request  an HttpServletRequest object that contains the request the client has made of the servlet
     * @param response an HttpServletResponse object that contains the response the servlet sends to the client
     * @throws IOException      - if an input or output error is detected when the servlet handles the GET request
     * @throws ServletException - if the request for the GET could not be handled
     */
    public final void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    /**
     * Called by the server (via the service method) to allow a servlet to handle a POST request.
     * The HTTP POST method allows the client to send data of unlimited length to the Web
     * server a single time and is useful when posting information such as credit card numbers.
     *
     * @param request  an HttpServletRequest object that contains the request the client has made of the servlet
     * @param response an HttpServletResponse object that contains the response the servlet sends to the client
     * @throws IOException      - if an input or output error is detected when the servlet handles the POST request
     * @throws ServletException - if the request for the POST could not be handled
     */
    public final void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException {
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        command.execute();
    }

    /**
     * Returns newly created instance of command that was got.
     *
     * @param request an HttpServletRequest object that contains the request the client has made of the servlet
     * @return front command that is detected(parsed from URL)
     */
    private FrontCommand getCommand(final HttpServletRequest request) {
        try {
            return (FrontCommand) getCommandClass(request).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets command, that is come in the request from the client side.
     * Special pattern is used: /StudyWebApp/(\w+).go.*
     *
     * @param request an HttpServletRequest object that contains the request the client has made of the servlet
     * @return name of the class, that represent the command to be executed.
     */
    @SuppressWarnings("rawtypes")
    private Class getCommandClass(final HttpServletRequest request) {

        Class result;
        Pattern pattern = Pattern.compile("/StudyWebApp/(\\w+).go.*");
        Matcher matcher = pattern.matcher(request.getRequestURI());

        final String commandClassName = "command." + (matcher.find() ? matcher.group(1) : "") + "Command";

        try {
            result = Class.forName(commandClassName);
        } catch (ClassNotFoundException e) {
            result = UnknownCommand.class;
        }

        return result;
    }

}
