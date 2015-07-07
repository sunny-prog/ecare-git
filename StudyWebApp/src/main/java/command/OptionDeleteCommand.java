package command;

import java.io.IOException;
import javax.servlet.ServletException;
/**
 * Provides business logic for option deleting.
 * It deletes option by it's id.
 *
 * @author Tatiana
 * @version 1.0
 */
public class OptionDeleteCommand extends OptionCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        getOptionService().delete(id);
        loadOptionsList();
    }
}
