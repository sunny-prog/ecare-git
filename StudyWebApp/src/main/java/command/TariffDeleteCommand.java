package command;

import javax.servlet.ServletException;
import java.io.IOException;
/**
 * Provides business logic for tariff deleting.
 * It deletes tariff by it's id.
 *
 * @author Tatiana
 * @version 1.0
 */
public class TariffDeleteCommand extends TariffCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        getTariffService().delete(id);
        loadTariffsList();
    }
}
