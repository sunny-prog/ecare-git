package command;

import entity.Option;
import entity.Tariff;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

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

        //Prepare list with all existing options
        List<Option> existingOptionsList = getOptionService().getAll();
        getRequest().setAttribute("existingOptionsList", existingOptionsList);

        //Prepare list with options available for this tariff
        List<Option> availableForTariffOptionsList = tariff.getOptions();
        getRequest().setAttribute("availableForTariffOptionsList", availableForTariffOptionsList);
        getRequest().setAttribute("action", "update");

        forward("/views/tariff.jsp");
    }
}
