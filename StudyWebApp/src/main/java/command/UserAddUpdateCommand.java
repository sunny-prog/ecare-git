package command;


import entity.User;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Tatiana on 08.06.2015.
 */
public class UserAddUpdateCommand extends UserCommand {

    @Override
    public void execute() throws ServletException, IOException {
        User user = new User();
        user.setEmail(getRequest().getParameter("email"));
        user.setName(getRequest().getParameter("name"));
        user.setSurname(getRequest().getParameter("surname"));
        user.setAge(Integer.valueOf(getRequest().getParameter("age")));
        if (getRequest().getParameter("id").isEmpty())
        {
            userService.add(user);
        }
        else
        {
            Long userId = Long.valueOf(getRequest().getParameter("id"));
            user.setId(userId);
            userService.update(user);
        }

        loadUsersList();
    }
}