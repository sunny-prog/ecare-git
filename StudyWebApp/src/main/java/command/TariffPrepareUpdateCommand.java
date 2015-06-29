package command;

import entity.Tariff;

import javax.servlet.ServletException;
import java.io.IOException;

public class TariffPrepareUpdateCommand extends TariffCommand {

    @Override
    public void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        Tariff tariff = getTariffService().get(id);
        getRequest().setAttribute("tariff", tariff);
        forward("/views/tariff.jsp");
    }
}
