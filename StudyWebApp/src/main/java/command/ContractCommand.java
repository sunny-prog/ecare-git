package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import service.IContractService;
import service.IUserService;
import service.ITariffService;
import utils.ServiceLocatorSingleton;
import entity.Contract;

/**
 * Is responsible for main service loading processing during real ContractCommand initialization. It establishes services for
 * IContractService, IUserService, ITariffService interfaces.
 *
 * @author Tatiana
 * @version 1.0
 */
public abstract class ContractCommand extends FrontCommand {
    /**
     * Service that provides working with contract functionality.
     */
    private IContractService contractService = null;

    /**
     * Service that provides working with user functionality.
     */
    private IUserService userService = null;

    /**
     * Service that provides working with tariff functionality.
     */
    private ITariffService tariffService = null;

    /**
     * Class constructor.
     */
    public ContractCommand() {
        super();
        setContractService((IContractService) ServiceLocatorSingleton.getInstance()
                .getService(IContractService.class));
        setUserService((IUserService) ServiceLocatorSingleton.getInstance()
                .getService(IUserService.class));
        setTariffService((ITariffService) ServiceLocatorSingleton.getInstance()
                .getService(ITariffService.class));
    }

    /**
     * Loads list of contracts currently stored in the DB table "Contract".
     *
     * @throws ServletException if there is something wrong with the servlet during forward() method call
     * @throws IOException      if there is something wrong with the IO during forward() method call
     */
    public final void loadContractsList() throws ServletException, IOException {
        List<Contract> list = contractService.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/contracts.jsp");
    }

    /**
     * Gets service to work with Contract that was registered in constructor by IContractService interface.
     *
     * @return this Contract's service.
     */
    public final IContractService getContractService() {
        return contractService;
    }

    /**
     * Sets service to work with Contract. Used during registration in constructor.
     *
     * @param contractService is a contract service to be set. It should implement IContractService interface.
     */
    public final void setContractService(final IContractService contractService) {
        this.contractService = contractService;
    }

    /**
     * Gets service to work with Contract that was registered in constructor by IContractService interface.
     *
     * @return this Contract's service.
     */
    public final IUserService getUserService() {
        return userService;
    }

    /**
     * Sets service to work with User. Used during registration in constructor.
     *
     * @param userService is a user service to be set. It should implement IUserService interface.
     */
    public final void setUserService(final IUserService userService) {
        this.userService = userService;
    }

    /**
     * Gets service to work with Contract that was registered in constructor by IContractService interface.
     *
     * @return this Contract's service.
     */
    public final ITariffService getTariffService() {
        return tariffService;
    }

    /**
     * Sets service to work with Tariff.
     *
     * @param tariffService is a tariff service to be set. It should implement ITariffService interface.
     */
    public final void setTariffService(final ITariffService tariffService) {
        this.tariffService = tariffService;
    }
}
