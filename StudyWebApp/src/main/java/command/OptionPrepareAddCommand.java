package command;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import entity.Option;

public class OptionPrepareAddCommand extends OptionCommand {

    @Override
    public void execute() throws ServletException, IOException {
        forward("/views/option.jsp");
    }
}