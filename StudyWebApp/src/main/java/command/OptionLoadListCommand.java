package command;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Provides business logic for loading all existing in the db options.
 *
 * @author Tatiana
 * @version 1.0
 */
public class OptionLoadListCommand extends OptionCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        loadOptionsList();
    }
}
