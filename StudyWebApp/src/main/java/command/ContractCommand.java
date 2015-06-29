package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import service.IContractService;
import service.IUserService;
import service.ITariffService;
import utils.ServiceLocatorSingleton;
import entity.Contract;

public class ContractCommand extends FrontCommand {
    private IContractService contractService = null;
    private IUserService userService = null;
    private ITariffService tariffService = null;

    public ContractCommand() {
        super();
        setContractService((IContractService) ServiceLocatorSingleton.getInstance()
                .getService(IContractService.class));
        setUserService((IUserService) ServiceLocatorSingleton.getInstance()
                .getService(IUserService.class));
        setTariffService((ITariffService) ServiceLocatorSingleton.getInstance()
                .getService(ITariffService.class));
    }

    @Override
    public void execute() throws ServletException, IOException {
        loadContractsList();
    }

    public void loadContractsList() throws ServletException, IOException {
        List<Contract> list = contractService.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/contracts.jsp");
    }

    public IContractService getContractService() {
        return contractService;
    }

    public void setContractService(IContractService contractService) {
        this.contractService = contractService;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public ITariffService getTariffService() {
        return tariffService;
    }

    public void setTariffService(ITariffService tariffService) {
        this.tariffService = tariffService;
    }

}
