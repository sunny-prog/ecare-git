package command;

import java.io.IOException;
import javax.servlet.ServletException;

/**
 * Executes simple case of unknown command. Just does redirect to the unknown.jsp page.
 *
 * @author Tatiana
 * @version 1.0
 */
public class UnknownCommand extends FrontCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        forward("/unknown.jsp");
    }
}
