package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import entity.User;
import service.IUserService;
import utils.ServiceLocatorSingleton;
/**
 * Makes loading all necessarily services for normal user functioning. It establishes services for
 * IUserService interface.
 *
 * @author Tatiana
 * @version 1.0
 */
public abstract class UserCommand extends FrontCommand {
    /**
     * Service that provides working with user functionality.
     */
    private IUserService userService = null;
    /**
     * Class constructor.
     */
    public UserCommand() {
        super();
        setUserService((IUserService) ServiceLocatorSingleton.getInstance().getService(IUserService.class));
    }
    /**
     * Loads list of users currently stored in the DB in corresponding table.
     *
     * @throws ServletException if there is something wrong with the servlet during forward() method call
     * @throws IOException      if there is something wrong with the IO during forward() method call
     */
    public final void loadUsersList() throws ServletException, IOException {
        List<User> list = userService.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/users.jsp");
    }
    /**
     * Gets service to work with user that was registered in constructor by IUserService interface.
     *
     * @return this users's service.
     */
    public final IUserService getUserService() {
        return userService;
    }
    /**
     * Sets service to work with user.
     *
     * @param userService is a user service to be set. It should implement IUserService interface.
     */
    public final void setUserService(final IUserService userService) {
        this.userService = userService;
    }
}
