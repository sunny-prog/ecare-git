package command;

import entity.Option;

import javax.servlet.ServletException;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.io.IOException;

public class OptionAddUpdateCommand extends OptionCommand {

    @Override
    public void execute() throws ServletException, IOException {
        Option option = new Option();
        //If "id" parameter in the request is not empty - we set it before hand (do not want to loose it)
        if (!getRequest().getParameter("id").isEmpty())
           option.setId(Long.valueOf(getRequest().getParameter("id")));

        try {
            Boolean priceIsOk = isNotBlankField("price") && isNumericFormat("price");
            if (priceIsOk) {
                String priceStringValue = canonicalize(getRequest().getParameter("price"));
                Integer priceValue = Integer.valueOf(priceStringValue);
                option.setPrice(priceValue);
                if (validateValue(Option.class, "price", priceValue) > 0) {
                    priceIsOk = Boolean.FALSE;
                }
            }

            Boolean activationCostIsOk = isNotBlankField("activationCost") && isNumericFormat("activationCost");
            if (activationCostIsOk) {
                String activationCostStringValue = canonicalize(getRequest().getParameter("activationCost"));
                Integer activationCostValue = Integer.valueOf(activationCostStringValue);
                option.setActivationCost(activationCostValue);
                if (validateValue(Option.class, "activationCost", activationCostValue) > 0) {
                    activationCostIsOk = Boolean.FALSE;
                }
            }

            Boolean titleIsOk = isNotBlankField("title") && isAsciiPrintableFormat("title");
            if (titleIsOk) {
                String titleValue = getRequest().getParameter("title");
                option.setTitle(canonicalize(titleValue));
                if (validateValue(Option.class, "title", titleValue) > 0) {
                    titleIsOk = Boolean.FALSE;
                }
            }

            // set option parameter to show correct data in the option form
            getRequest().setAttribute("option", option);

            if (!priceIsOk || !activationCostIsOk || !titleIsOk) {
                forward("/views/option.jsp");
                return;
            }

            // TO ASK - нужно ли делать валидацию сущности, если я до этого провалидировала значения всех свойств по отдельности?
            validate(option);

        } catch (ValidationException ex) {
            // TO ASK - нужно ли ловить это исключение? Каковы шансы того, что оно у меня вывалится?
            // In case of some validation errors still detected
            getRequest().setAttribute("ErrorMessage", "Data format is incorrect");
            forward("/views/option.jsp");
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            //ADDING new option case - no id
            if (getRequest().getParameter("id").isEmpty()) {
                getOptionService().add(option);

                //Form for updating existing option was fulfilled - id is already generated
            } else {
                getOptionService().update(option);
            }

        } catch (ConstraintViolationException ex) {

            forward("/views/option.jsp");
            return;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        loadOptionsList();
    }

}