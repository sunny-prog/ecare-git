package command;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Provides business logic for loading all existing in the db users.
 *
 * @author Tatiana
 * @version 1.0
 */
public class UserLoadListCommand extends UserCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        loadUsersList();
    }
}
