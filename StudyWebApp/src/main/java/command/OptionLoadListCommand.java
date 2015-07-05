package command;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Tatiana on 05.07.2015.
 */
public class OptionLoadListCommand extends OptionCommand {

    @Override
    public void execute() throws ServletException, IOException {
        loadOptionsList();
    }
}
