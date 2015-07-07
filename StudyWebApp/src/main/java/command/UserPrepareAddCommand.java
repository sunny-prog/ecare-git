package command;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Tatiana on 08.06.2015.
 */

public class UserPrepareAddCommand extends UserCommand {
    /**
     * Provides business logic for preparing all what is needed to adding new user process.
     * At the end it forwards the request to the jsp page to create new user.
     *
     * @author Tatiana
     * @version 1.0
     */
    @Override
    public final void execute() throws ServletException, IOException {
        forward("/views/user.jsp");
    }
}
