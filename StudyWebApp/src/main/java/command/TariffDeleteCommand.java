package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import entity.Tariff;

public class TariffDeleteCommand extends TariffCommand {

	@Override
	public void execute() throws ServletException, IOException {
		Long id = Long.valueOf(getRequest().getParameter("id"));
		tariffService.deleteTariffById(id);
		List<Tariff> list = tariffService.getAll();
		loadTariffsList(list);

	}
}
