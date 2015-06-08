package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import service.ITariffService;
import utils.ServiceLocatorSingleton;
import entity.Tariff;

public class TariffCommand extends FrontCommand {
    protected ITariffService tariffService = null;

    public TariffCommand() {
        super();
        setTariffService((ITariffService) ServiceLocatorSingleton.getInstance()
                .getService(ITariffService.class));
    }

    @Override
    public void execute() throws ServletException, IOException {
        loadTariffsList();
    }

    public void loadTariffsList() throws ServletException, IOException {
        List<Tariff> list = tariffService.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/tariffs.jsp");
    }

    public ITariffService getTariffService() {
        return tariffService;
    }

    public void setTariffService(ITariffService tariffService) {
        this.tariffService = tariffService;
    }
}
