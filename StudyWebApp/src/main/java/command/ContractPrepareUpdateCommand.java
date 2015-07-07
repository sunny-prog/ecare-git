package command;

import entity.Contract;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Provides business logic for preparing everything that is needed to updating
 * contract process (it loads the contract to the request attribute).
 * At the end it forwards the request to the jsp page to update existing contract.
 *
 * @author Tatiana
 * @version 1.0
 */
public class ContractPrepareUpdateCommand extends ContractCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        Contract contract = getContractService().get(id);
        getRequest().setAttribute("contract", contract);
        forward("/views/contract.jsp");
    }
}
