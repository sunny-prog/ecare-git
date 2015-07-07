package command;

import entity.Option;

import javax.servlet.ServletException;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.io.IOException;

/**
 * Provide business logic for "OptionAddUpdate" command.
 * It validates user's input and distinguishes between Add and Update
 * business cases. In case of Add command it adds new option to the data base.
 * In case of update it updates option in the data base.
 * Finally at the end of the processing it loads options list to the user.
 *
 * @author Tatiana
 * @version 1.0
 */
public class OptionAddUpdateCommand extends OptionCommand {

    @Override
    public final void execute() throws ServletException, IOException {
        Option option = new Option();

        try {
            //If "id" parameter in the request is not empty - we set it before hand (do not want to loose it)
            if (!getRequest().getParameter("id").isEmpty()) {
                option.setId(Long.valueOf(getRequest().getParameter("id")));
            }

            // check format and validate incoming parameters
            if (Boolean.TRUE.equals(validationIsFailed(option))) {
                forward("/views/option.jsp");
                return;
            }

            //ADDING new option in case - no id
            if (getRequest().getParameter("id").isEmpty()) {
                getOptionService().add(option);

                //Form for updating existing option was fulfilled - id is already generated
            } else {
                getOptionService().update(option);
            }

        } catch (ConstraintViolationException ex) {
            /* if some validation problems occur during persist and update ib DB */
            forward("/views/option.jsp");
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        loadOptionsList();
    }

    /**
     * Checks if incoming parameters corresponds proper format. Also validates each parameter by calling
     * validateValue (Validation bean API), if it has proper format.
     *
     * @param option is an object which will be fulfilled with proper canonicalized values, if they are passed in request.
     * @return true value is returned, if validation failed at least in one place.
     * @throws ServletException if there is something wrong with the servlet during forward() method call
     * @throws IOException      if there is something wrong with the IO during forward() method call
     */
    private boolean validationIsFailed(final Option option) throws IOException, ServletException {
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
                return true;
            }

            validate(option);
        } catch (ValidationException ex) {
            // In case of some validation errors still detected
            getRequest().setAttribute("ErrorMessage", "Data format is incorrect");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
