package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import service.IOptionService;
import utils.ServiceLocatorSingleton;
import entity.Option;

/**
 * This class does main service loading processing.
 *
 * @author Tatiana
 * @version 1.0
 */
public abstract class OptionCommand extends FrontCommand {
    private IOptionService optionService = null;

    public OptionCommand() {
        super();
        setOptionService((IOptionService) ServiceLocatorSingleton.getInstance()
                .getService(IOptionService.class));
    }

    public void loadOptionsList() throws ServletException, IOException {
        List<Option> list = optionService.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/options.jsp");
    }

    public IOptionService getOptionService() {
        return optionService;
    }

    public void setOptionService(IOptionService optionService) {
        this.optionService = optionService;
    }
}
