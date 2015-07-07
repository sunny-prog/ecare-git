package command;

import javax.servlet.ServletException;
import java.io.IOException;
/**
 * Provides business logic for user deleting.
 * It deletes user by it's id.
 *
 * @author Tatiana
 * @version 1.0
 */
public class UserDeleteCommand extends UserCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        getUserService().delete(id);
        loadUsersList();
    }
}
