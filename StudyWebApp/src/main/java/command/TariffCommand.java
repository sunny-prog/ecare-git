package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import service.ITariffService;
import utils.ServiceLocatorSingleton;
import entity.Tariff;
/**
 * Makes loading all necessarily services for normal tariff functioning. It establishes services for
 * ITariffService interface.
 *
 * @author Tatiana
 * @version 1.0
 */
public abstract class TariffCommand extends FrontCommand {
    /**
     * Service that provides working with tariff functionality.
     */
    private ITariffService tariffService = null;
    /**
     * Class constructor.
     */
    public TariffCommand() {
        super();
        setTariffService((ITariffService) ServiceLocatorSingleton.getInstance()
                .getService(ITariffService.class));
    }
    /**
     * Loads list of tariffs currently stored in the DB in corresponding table.
     *
     * @throws ServletException if there is something wrong with the servlet during forward() method call
     * @throws IOException      if there is something wrong with the IO during forward() method call
     */
    public final void loadTariffsList() throws ServletException, IOException {
        List<Tariff> list = tariffService.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/tariffs.jsp");
    }
    /**
     * Gets service to work with tariff that was registered in constructor by ITariffService interface.
     *
     * @return this Contract's service.
     */
    public final ITariffService getTariffService() {
        return tariffService;
    }
    /**
     * Sets service to work with tariff.
     *
     * @param tariffService is a tariff service to be set. It should implement ITariffService interface.
     */
    public final void setTariffService(final ITariffService tariffService) {
        this.tariffService = tariffService;
    }
}
