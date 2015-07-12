package command;

import entity.Option;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Provides business logic for preparing all what is needed to adding new tariff process.
 * At the end it forwards the request to the jsp page to create new tariff.
 *
 * @author Tatiana
 * @version 1.0
 */
public class TariffPrepareAddCommand extends TariffCommand {

    @Override
    public final void execute() throws ServletException, IOException {

        List<Option> existingOptionsList = getOptionService().getAll();
        getRequest().setAttribute("existingOptionsList", existingOptionsList);

        forward("/views/tariff.jsp");
    }
}
