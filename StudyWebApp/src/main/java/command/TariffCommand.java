package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import entity.Tariff;
import entity.User;
import service.TariffService;
import service.UserService;


public class TariffCommand extends FrontCommand {
	private TariffService tariffService;
    @Override
    public void execute() throws ServletException, IOException {
        loadTariffsList();
    }

    public void loadTariffsList() throws ServletException, IOException{
    	TariffService tariffService = serviceLocator.getService("tariffService");
        List<Tariff> list = tariffService.getAll();
        getRequest().setAttribute("list", list);
        forward("/views/tariff.jsp") ;
    }
    
    public void loadUsersList(List<Tariff> list) throws ServletException, IOException{
        getRequest().setAttribute("list", list);
        forward("/views/tariff.jsp") ;
    }
}
