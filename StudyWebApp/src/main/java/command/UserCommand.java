package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import entity.User;
import service.IUserService;
import utils.ServiceLocatorSingleton;

public abstract class UserCommand extends FrontCommand {
    private IUserService userService = null;

    public UserCommand() {
        super();
        setUserService((IUserService) ServiceLocatorSingleton.getInstance().getService(IUserService.class));
    }

    public void loadUsersList() throws ServletException, IOException {
        List<User> list = userService.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/users.jsp");
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
