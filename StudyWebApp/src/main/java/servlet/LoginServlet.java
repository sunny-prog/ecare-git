package servlet;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

/**
 * Provides an entry point for handling requests from login page.
 *
 * @author Tatiana
 * @version 1.0
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    /**
     * Explicitly declares serialVersionUID values, since the default serialVersionUID computation
     * is highly sensitive to class details.
     */
    private static final long serialVersionUID = 2L;
    private final String userID = "salesman";
    private final String password = "123";

    /**
     * Method processes POST requests from login.jsp page.
     *
     * @param request  http servlet request
     * @param response http servlet responce
     * @throws ServletException if error in servlet
     * @throws IOException      if error in IO
     */
    protected final void doPost(final HttpServletRequest request,
                                final HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        // get request parameters for userID and password
        String login = request.getParameter("login");
        String pwd = request.getParameter("password");

        User user = validateLogin(login, pwd);

        if (user == null) {
            request.setAttribute("ErrorMessage", "      Either user name or password is wrong.");
            rd = request.getRequestDispatcher("/login.jsp");
        } else {
            //Creates session, if it does not exist
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            //setting session to expiry in 30 mins
            //session.setMaxInactiveInterval(30 * 60);
            //Cookie userName = new Cookie("user", login);
            //userName.setMaxAge(30 * 60);
            //response.addCookie(userName);

            // There are two roles in system "salesman" and "client"
            if ("salesman".equals(user.getRole())) {
                rd = request.getRequestDispatcher("/views/salesman.jsp");
            } else {
                rd = request.getRequestDispatcher("/views/client.jsp");
            }
        }
        rd.forward(request, response);
    }

    /**
     * Validate the entered data.
     * <p>
     * If there is no valid data, the method will return null
     *
     * @param pName     given at the jsp
     * @param pPassword given at the jsp
     * @return a user if one was found and validated
     */
    private User validateLogin(final String pName, final String pPassword) {
        // All parameters must be valid
        if (pName == null || pPassword == null) {
            return null;
        }

        // Get a user by key
        //  User user = users.get(name);
        User user = new User();
        user.setName("Ivan");
        user.setPassword("123");
        user.setRole("salesman");

        if (user == null) {
            return null;
        }

        // Check if the password is valid
        if (!user.getPassword().equals(pPassword.trim())) {
            return null;
        }
        return user;
    }

}

