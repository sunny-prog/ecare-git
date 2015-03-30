package command;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import entity.User;
import service.UserService;

public class UserCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {
        String action = getRequest().getParameter("action");
        UserService service = new UserService();
        loadUsersList();
    }

    public void loadUsersList() throws ServletException, IOException{
        UserService service = new UserService();
        List<User> list = service.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/user.jsp") ;
    }
}
