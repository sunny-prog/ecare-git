package command;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import entity.Option;

public class OptionDeleteCommand extends OptionCommand {

	@Override
	public void execute() throws ServletException, IOException {
		Long id = Long.valueOf(getRequest().getParameter("id"));
		optionService.deleteOptionById(id);
		List<Option> list = optionService.getAll();
		loadOptionsList(list);
	}
}
