package command;

import java.io.IOException;
import javax.servlet.ServletException;
import entity.Option;

public class OptionAddUpdateCommand extends OptionCommand {

    @Override
    public void execute() throws ServletException, IOException {
        Option option = new Option();
        option.setPrice(Integer.valueOf(getRequest().getParameter("price")));
        option.setTitle(getRequest().getParameter("title"));
        option.setActivationCost(Integer.valueOf(getRequest().getParameter("activationCost")));
        if (getRequest().getParameter("id").isEmpty())
        {
            optionService.addOption(option);
        }
        else
        {
            Long optionId = Long.valueOf(getRequest().getParameter("id"));
            option.setId(optionId);
            optionService.updateOption(option);
        }

        loadOptionsList();
    }
}