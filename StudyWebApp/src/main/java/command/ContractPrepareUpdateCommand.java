package command;

import entity.Contract;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * This class provides business logic for "ContractPrepareUpdate" command.
 * It forwards the request to the jsp page to update existing contract,
 * but before hand it loads the contract to the request attribute.
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
