package command;

import java.io.IOException;
import javax.servlet.ServletException;

public class OptionPrepareAddCommand extends OptionCommand {

    @Override
    public void execute() throws ServletException, IOException {
        forward("/views/option.jsp");
    }
}