package command;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Provides business logic for loading all existing in the db tariffs.
 *
 * @author Tatiana
 * @version 1.0
 */
public class TariffLoadListCommand extends TariffCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        loadTariffsList();
    }
}
