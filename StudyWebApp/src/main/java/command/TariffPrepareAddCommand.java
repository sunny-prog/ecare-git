package command;

import java.io.IOException;
import javax.servlet.ServletException;

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
        forward("/views/tariff.jsp");
    }
}