package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import entity.Tariff;
import service.TariffService;


public class TariffCommand extends FrontCommand {
	private TariffService tariffService;
    @Override
    public void execute() throws ServletException, IOException {
        //String action = getRequest().getParameter("action");
        //TariffService service = new TariffService();
        loadTariffsList();
    }

    public void loadTariffsList() throws ServletException, IOException{
    	tariffService = new TariffService();
        List<Tariff> list = tariffService.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/tariff.jsp") ;
    }
}
