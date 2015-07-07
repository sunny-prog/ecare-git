package command;

import entity.Tariff;

import javax.servlet.ServletException;
import java.io.IOException;
/**
 * Provides business logic for "TariffAddUpdate" command.
 * It validates user's input and distinguishes between Add and Update
 * business cases. In case of Add command it adds new tariff to the DB.
 * In case of update it updates tariff in the DB.
 * Finally at the end of the processing it loads list of all saved in DB tariffs to the user.
 *
 * @author Tatiana
 * @version 1.0
 */
public class TariffAddUpdateCommand extends TariffCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Tariff tariff = new Tariff();
        tariff.setPrice(Integer.valueOf(getRequest().getParameter("price")));
        tariff.setTitle(getRequest().getParameter("title"));
        if (getRequest().getParameter("id").isEmpty()) {
            getTariffService().add(tariff);
        } else {
            Long tariffId = Long.valueOf(getRequest().getParameter("id"));
            tariff.setId(tariffId);
            getTariffService().update(tariff);
        }

        loadTariffsList();
    }
}
