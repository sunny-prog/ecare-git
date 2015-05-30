package command;

import java.io.IOException;
import javax.servlet.ServletException;

public class OptionDeleteCommand extends OptionCommand {

	@Override
	public void execute() throws ServletException, IOException {
		Long id = Long.valueOf(getRequest().getParameter("id"));
		optionService.deleteOptionById(id);
		loadOptionsList();
	}
}
