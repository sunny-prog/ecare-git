package command;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import entity.User;
import service.UserService;

public class UserCommand extends FrontCommand {

	 
    @Override
    public void execute() throws ServletException, IOException {
        loadUsersList();
    }

    public void loadUsersList() throws ServletException, IOException{
    	UserService userService = serviceLocator.getService("userService");
        List<User> list = userService.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/user.jsp") ;
    }
    
    public void loadUsersList(List<User> list) throws ServletException, IOException{
        getRequest().setAttribute("list", list);
        forward("/views/user.jsp") ;
    }
}
