package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Provides an entry point for handling requests from sign out link.
 *
 * @author Tatiana
 * @version 1.0
 */

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    /**
     * Explicitly declares serialVersionUID values, since the default serialVersionUID computation
     * is highly sensitive to class details.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Main method to process requests of POST type coming from log out page.
     *
     * @param request  http request
     * @param response http responce
     * @throws ServletException if error in servlet
     * @throws IOException      if error in IO
     */
    protected final void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println("JSESSIONID=" + cookie.getValue());
                    break;
                }
            }
        }

        // will not create if not exist, as false as parameter
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.removeAttribute("user");
            //invalidate the session if exists
            session.invalidate();
        }
        //request.getContextPath()
        response.sendRedirect("index.jsp");
    }

}
