package command;

import java.io.IOException;
import javax.servlet.ServletException;

import entity.Option;

public class OptionPrepareUpdateCommand extends OptionCommand {

    @Override
    public void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        Option option = getOptionService().get(id);
        getRequest().setAttribute("option", option);
        forward("/views/option.jsp");
    }
}
