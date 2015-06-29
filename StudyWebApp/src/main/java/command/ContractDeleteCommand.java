package command;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import entity.Contract;

public class ContractDeleteCommand extends ContractCommand {

	@Override
	public void execute() throws ServletException, IOException {
		Long id = Long.valueOf(getRequest().getParameter("id"));
		getContractService().delete(id);
		loadContractsList();
	}
}