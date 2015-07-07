package command;

import java.io.IOException;
import javax.servlet.ServletException;

/**
 * Provides business logic for contract deleting.
 * It deletes command by it's id.
 *
 * @author Tatiana
 * @version 1.0
 */
public class ContractDeleteCommand extends ContractCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        getContractService().delete(id);
        loadContractsList();
    }
}
