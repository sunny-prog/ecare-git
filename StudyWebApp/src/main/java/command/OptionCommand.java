package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import service.IOptionService;
import utils.ServiceLocatorSingleton;
import entity.Option;

/**
 * Is responsible for main service loading processing during real OptionCommand initialization.
 * It establishes services for IOptionService.
 *
 * @author Tatiana
 * @version 1.0
 */
public abstract class OptionCommand extends FrontCommand {
    /**
     * Service that provides working with option functionality.
     */
    private IOptionService optionService = null;
    /**
     * Class constructor.
     */
    public OptionCommand() {
        super();
        setOptionService((IOptionService) ServiceLocatorSingleton.getInstance()
                .getService(IOptionService.class));
    }
    /**
     * Loads list of options currently stored in the DB in corresponding table.
     *
     * @throws ServletException if there is something wrong with the servlet during forward() method call
     * @throws IOException      if there is something wrong with the IO during forward() method call
     */
    public final void loadOptionsList() throws ServletException, IOException {
        List<Option> list = optionService.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/options.jsp");
    }
    /**
     * Gets service to work with option that was registered in constructor by IOptionService interface.
     *
     * @return this Option's service.
     */
    public final IOptionService getOptionService() {
        return optionService;
    }
    /**
     * Sets service to work with option.
     *
     * @param optionService is a option service to be set. It should implement IOptionService interface.
     */
    public final void setOptionService(final IOptionService optionService) {
        this.optionService = optionService;
    }
}

