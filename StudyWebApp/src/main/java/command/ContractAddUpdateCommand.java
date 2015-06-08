package command;

import java.io.IOException;
import javax.servlet.ServletException;

import entity.Contract;

public class ContractAddUpdateCommand extends ContractCommand {

    @Override
    public void execute() throws ServletException, IOException {
        Contract contract = new Contract();
        contract.setContractNumber(getRequest().getParameter("contractNumber"));
        contract.setClient(userService.get(Long.valueOf(getRequest().getParameter("clientId"))));
        contract.setTariff(tariffService.get(Long.valueOf(getRequest().getParameter("tariffId"))));
        contract.setBlockedBySalesman(Boolean.valueOf(getRequest().getParameter("blockedBySalesman")));
        contract.setBlockedByClient(Boolean.valueOf(getRequest().getParameter("blockedByClient")));

        if (getRequest().getParameter("id").isEmpty()) {
            contractService.add(contract);
        } else {
            Long optionId = Long.valueOf(getRequest().getParameter("id"));
            contract.setId(optionId);
            contractService.update(contract);
        }

        loadContractsList();
    }
}