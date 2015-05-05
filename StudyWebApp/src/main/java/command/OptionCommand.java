package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import service.IOptionService;
import utils.ServiceLocatorSingleton;
import entity.Option;

public class OptionCommand extends FrontCommand {
	protected IOptionService optionService = null;

	public OptionCommand() {
		super();
		setOptionService((IOptionService) ServiceLocatorSingleton.getInstance()
				.getService(IOptionService.class));
	}

	@Override
	public void execute() throws ServletException, IOException {
		loadOptionsList();
	}

	public void loadOptionsList() throws ServletException, IOException {
		List<Option> list = optionService.getAll();
		getRequest().setAttribute("list", list);
		forward("/views/option.jsp");
	}

	public void loadOptionsList(List<Option> list) throws ServletException,
			IOException {
		getRequest().setAttribute("list", list);
		forward("/views/option.jsp");
	}

	public IOptionService getOptionService() {
		return optionService;
	}

	public void setOptionService(IOptionService optionService) {
		this.optionService = optionService;
	}
}
