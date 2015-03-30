package command;

import java.io.IOException;
import javax.servlet.ServletException;
import service.TariffService;

public class TariffDeleteCommand extends TariffCommand {

	@Override
	public void execute() throws ServletException, IOException {

		TariffService service = new TariffService();

		Long id = Long.valueOf(getRequest().getParameter("id"));
		service.delete(id);
		loadTariffsList();

	}
}
