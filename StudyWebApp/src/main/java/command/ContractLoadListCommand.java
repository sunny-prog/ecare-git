package command;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Provides business logic for loading all existing in the db contracts.
 *
 * @author Tatiana
 * @version 1.0
 */
public class ContractLoadListCommand extends ContractCommand {
    @Override
    public final void execute() throws ServletException, IOException {
        loadContractsList();
    }
}
