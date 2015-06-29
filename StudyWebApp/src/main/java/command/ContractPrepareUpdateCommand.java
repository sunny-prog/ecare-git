package command;

import entity.Contract;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by Tatiana on 08.06.2015.
 */
public class ContractPrepareUpdateCommand extends ContractCommand {

    @Override
    public void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        Contract contract = getContractService().get(id);
        getRequest().setAttribute("contract", contract);
        forward("/views/contract.jsp");
    }
}
