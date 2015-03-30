package command;

import java.io.IOException;
import javax.servlet.ServletException;

public class UnknownCommand extends FrontCommand {

    @Override
    public void execute() throws ServletException, IOException {
        forward("/unknown.jsp");
    }

}