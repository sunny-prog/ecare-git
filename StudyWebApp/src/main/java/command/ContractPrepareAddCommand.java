package command;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Provides business logic for preparing all what is needed to adding new contract process.
 * At the end it forwards the request to the jsp page to create new contract.
 *
 * @author Tatiana
 * @version 1.0
 */
public class ContractPrepareAddCommand extends ContractCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        forward("/views/contract.jsp");
    }
}
