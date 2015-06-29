package command;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;

import entity.User;

public class UserDeleteCommand extends UserCommand {

    @Override
    public void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        getUserService().delete(id);
        loadUsersList();
    }
}
