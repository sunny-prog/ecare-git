package command;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import entity.Contract;

public class ContractDeleteCommand extends ContractCommand {

	@Override
	public void execute() throws ServletException, IOException {
		Long id = Long.valueOf(getRequest().getParameter("id"));
		contractService.deleteContractById(id);
		List<Contract> list = contractService.getAll();
		loadContractsList(list);
	}
}