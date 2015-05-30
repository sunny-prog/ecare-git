package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import service.IContractService;
import utils.ServiceLocatorSingleton;
import entity.Contract;

public class ContractCommand extends FrontCommand {
	protected IContractService contractService = null;

	public ContractCommand() {
		super();
		setContractService((IContractService) ServiceLocatorSingleton.getInstance()
				.getService(IContractService.class));
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

	public void loadContractsList(List<Contract> list) throws ServletException,
			IOException {
		getRequest().setAttribute("list", list);
		forward("/views/contracts.jsp");
	}

	public IContractService getContractService() {
		return contractService;
	}

	public void setContractService(IContractService contractService) {
		this.contractService = contractService;
	}
}
