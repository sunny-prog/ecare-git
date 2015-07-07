package command;

import entity.Tariff;

import javax.servlet.ServletException;
import java.io.IOException;
/**
 * Provides business logic for preparing everything that is needed to updating
 * tariff process (it loads the tariff to the request attribute).
 * At the end it forwards the request to the jsp page to update existing tariff.
 *
 * @author Tatiana
 * @version 1.0
 */
public class TariffPrepareUpdateCommand extends TariffCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        Tariff tariff = getTariffService().get(id);
        getRequest().setAttribute("tariff", tariff);
        forward("/views/tariff.jsp");
    }
}
