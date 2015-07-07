package command;

import entity.User;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Provides business logic for preparing everything that is needed to updating
 * user process (it loads the user to the request attribute.).
 * At the end it forwards the request to the jsp page to update existing user.
 *
 * @author Tatiana
 * @version 1.0
 */
public class UserPrepareUpdateCommand extends UserCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        User user = getUserService().get(id);
        getRequest().setAttribute("user", user);
        forward("/views/user.jsp");
    }
}
