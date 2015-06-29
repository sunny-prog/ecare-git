package command;

import entity.User;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Tatiana on 08.06.2015.
 */
public class UserPrepareUpdateCommand extends UserCommand {

    @Override
    public void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        User user = getUserService().get(id);
        getRequest().setAttribute("user", user);
        forward("/views/user.jsp");
    }
}