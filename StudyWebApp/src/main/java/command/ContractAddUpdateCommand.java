package command;

import java.io.IOException;
import javax.servlet.ServletException;

import entity.Contract;

/**
 * This class provides business logic for "ContractAddUpdate" command.
 * It validates user's input and distinguishes between Add and Update
 * business cases. In case of Add command it adds new contract to the DB.
 * In case of update it updates contract in the DB.
 * Finally at the end of the processing it loads list of all saved in DB contracts to the user.
 *
 * @author Tatiana
 * @version 1.0
 */
public class ContractAddUpdateCommand extends ContractCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Contract contract = new Contract();
        contract.setContractNumber(getRequest().getParameter("contractNumber"));
        contract.setClient(getUserService().get(Long.valueOf(getRequest().getParameter("clientId"))));
        contract.setTariff(getTariffService().get(Long.valueOf(getRequest().getParameter("tariffId"))));
        contract.setBlockedBySalesman(Boolean.valueOf(getRequest().getParameter("blockedBySalesman")));
        contract.setBlockedByClient(Boolean.valueOf(getRequest().getParameter("blockedByClient")));

        if (getRequest().getParameter("id").isEmpty()) {
            getContractService().add(contract);
        } else {
            Long optionId = Long.valueOf(getRequest().getParameter("id"));
            contract.setId(optionId);
            getContractService().update(contract);
        }

        loadContractsList();
    }
}
