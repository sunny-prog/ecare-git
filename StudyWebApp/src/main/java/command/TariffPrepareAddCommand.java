package command;

import java.io.IOException;
import javax.servlet.ServletException;

public class TariffPrepareAddCommand extends TariffCommand {

    @Override
    public void execute() throws ServletException, IOException {
        forward("/views/tariff.jsp");
    }
}