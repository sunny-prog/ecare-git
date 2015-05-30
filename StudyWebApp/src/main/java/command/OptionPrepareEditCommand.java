package command;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import entity.Option;

public class OptionPrepareEditCommand extends OptionCommand {

    @Override
    public void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        Option option = optionService.getOptionById(id);
        getRequest().setAttribute("option", option);
        forward("/views/option.jsp");
    }
}
