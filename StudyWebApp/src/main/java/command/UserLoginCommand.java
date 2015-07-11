package command;

import entity.User;
import utils.CONSTANT;
import utils.ECareAppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Processes user login command.
 *
 * @author Tatiana
 * @version 1.0
 */
public class UserLoginCommand extends UserCommand {
    @Override
    public final void execute() throws ServletException, IOException {
        // get request parameters for userID and password

        String target = null;
        User user = null;

        try {
            user = validateLogin("login", "password");
        } catch (ECareAppException ex) {
            getRequest().setAttribute("ErrorMessage", "          " + ex.getMessage());
            target = "/login.jsp";
            forward(target);
            return;
        }


        //Creates session, if it does not exist
        HttpSession session = getRequest().getSession();
        session.setAttribute("user", user);

        //setting session to expiry in 30 mins
        //session.setMaxInactiveInterval(30 * 60);
        //Cookie userName = new Cookie("user", login);
        //userName.setMaxAge(30 * 60);
        //response.addCookie(userName);

        // There are two roles in system "salesman" and "client"
        if (CONSTANT.SALESMAN_ROLE_NAME.equals(user.getRole())) {
            target = CONSTANT.SALESMAN_WELCOME_PAGE;
        } else {
            target = CONSTANT.CLIENT_WELCOME_PAGE;
        }
        forward(target);
    }

    /**
     * Validate the entered data.
     * <p>
     * If there is no valid data, the method will return null
     *
     * @param pLogin    given at the jsp
     * @param pPassword given at the jsp
     * @return a user if one was found and validated
     * @throws ECareAppException if one or two field ae empty, if user is not found
     *                           in DB and if password is differ from that is stored in DB
     */
    private User validateLogin(final String pLogin, final String pPassword) throws ECareAppException {

        Boolean loginIsOk = isNotBlankField(pLogin);
        Boolean passwordIsOk = isNotBlankField(pPassword);
        if (!loginIsOk || !passwordIsOk) {
            throw new ECareAppException("Empty field is detected.");
        }

        String login = getRequest().getParameter(pLogin);
        String pwd = getRequest().getParameter(pPassword);

        User user = getUserService().getUserByEmail(login);

        // Check if the password is valid
        if (!user.getPassword().equals(pwd.trim())) {
            throw new ECareAppException("Password is incorrect");
        }
        return user;
    }
}

