package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import entity.Tariff;
import entity.User;
import service.TariffService;
import service.UserService;

public class TariffDeleteCommand extends TariffCommand {

	@Override
	public void execute() throws ServletException, IOException {

		TariffService tariffservice = serviceLocator
				.getService("tariffService");
		Long id = Long.valueOf(getRequest().getParameter("id"));
		tariffservice.deleteTariffById(id);
		List<Tariff> list = tariffservice.getAll();
		loadUsersList(list);

	}
}
