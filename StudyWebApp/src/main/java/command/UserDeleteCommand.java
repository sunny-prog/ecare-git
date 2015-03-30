package command;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import entity.User;
import service.UserService;

public class UserDeleteCommand extends UserCommand {

    @Override
    public void execute() throws ServletException, IOException {
        
        UserService service = new UserService();
                
        String email = getRequest().getParameter("email");
        service.delete(email);
        loadUsersList();
        
    }
}

