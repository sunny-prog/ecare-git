package command;

import entity.Tariff;

import javax.servlet.ServletException;
import java.io.IOException;

public class TariffAddUpdateCommand extends TariffCommand {

    @Override
    public void execute() throws ServletException, IOException {
        Tariff tariff = new Tariff();
        tariff.setPrice(Integer.valueOf(getRequest().getParameter("price")));
        tariff.setTitle(getRequest().getParameter("title"));
        if (getRequest().getParameter("id").isEmpty())
        {
            tariffService.add(tariff);
        }
        else
        {
            Long tariffId = Long.valueOf(getRequest().getParameter("id"));
            tariff.setId(tariffId);
            tariffService.update(tariff);
        }

        loadTariffsList();
    }
}