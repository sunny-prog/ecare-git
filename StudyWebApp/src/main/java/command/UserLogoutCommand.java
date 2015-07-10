package command;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Processes user logout command.
 *
 * @author Tatiana
 * @version 1.0
 */
public class UserLogoutCommand extends UserCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        getResponse().setContentType("text/html");
        Cookie[] cookies = getRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println("JSESSIONID=" + cookie.getValue());
                    break;
                }
            }
        }

        // will not create if not exist, as false as parameter
        HttpSession session = getRequest().getSession(false);

        if (session != null) {
            session.removeAttribute("user");
            //invalidate the session if exists
            session.invalidate();
        }
        //request.getContextPath()
        getResponse().sendRedirect("index.jsp");
    }

}

