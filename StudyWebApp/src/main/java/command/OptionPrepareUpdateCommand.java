package command;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;

import entity.Option;

/**
 * Provides business logic for preparing everything that is needed to updating
 * option process (it loads the option to the request attribute).
 * At the end it forwards the request to the jsp page to update existing option.
 *
 * @author Tatiana
 * @version 1.0
 */
public class OptionPrepareUpdateCommand extends OptionCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Long id = Long.valueOf(getRequest().getParameter("id"));
        Option option = getOptionService().get(id);
        getRequest().setAttribute("option", option);

        //Prepare list with all existing options
        List<Option> existingOptionsList = getOptionService().getAll();

       /* for(Option existingOption: existingOptionsList){
            if(existingOption.getId().equals(option.getId())){
                existingOptionsList.remove(existingOption);
            }
        }*/

        Iterator<Option> iter = existingOptionsList.iterator();
        while (iter.hasNext()) {
            Option existingOption = iter.next();
            if (existingOption.getId().equals(option.getId())) {
                iter.remove();
            }
        }

        //existingOptionsList.remove(option);
        getRequest().setAttribute("existingOptionsList", existingOptionsList);

        //Prepare list with options required for this option
        List<Option> requiredOptionsList = option.getRequiredOptions();
        getRequest().setAttribute("requiredOptionsList", requiredOptionsList);

        //Prepare list with options incompatible for this option
        List<Option> incompatibleOptionsList = option.getIncompatibleOptions();
        getRequest().setAttribute("incompatibleOptionsList", incompatibleOptionsList);

        getRequest().setAttribute("action", "update");


        forward("/views/option.jsp");
    }
}
