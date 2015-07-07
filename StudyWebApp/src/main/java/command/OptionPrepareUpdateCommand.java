package command;

import java.io.IOException;
import javax.servlet.ServletException;

import entity.Option;
/**
 * Provides business logic for preparing everything that is needed to updating
 * option process (it loads the option to the request attribute).
 * At the end it forwards the request to the jsp page to update existing option.
 *
 * @author Tatiana
 * @version 1.0
 */
public class OptionPrepareUpdateCommand extends OptionCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        Option option = getOptionService().get(id);
        getRequest().setAttribute("option", option);
        forward("/views/option.jsp");
    }
}
