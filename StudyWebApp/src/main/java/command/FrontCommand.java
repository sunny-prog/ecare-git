package command;

import org.apache.commons.lang3.StringUtils;
import utils.ServiceLocatorSingleton;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;

import static org.apache.commons.lang3.StringUtils.isAsciiPrintable;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * This is main class that realizes FrontServlet pattern. Each request is processed to get command.
 * FrontCommand is abstract class - super class for all existing commands.
 * <p>
 * It provides generic methods to do the same validation work with different entities.
 * And this class provides methods to check format of the request parameters, that comes as strings.
 *
 * @param <T> it could be any type among those used in this webapplication( Tariff, Option, Contract, User)
 * @author Tatiana
 * @version 1.0
 */
public abstract class FrontCommand<T> {
    /**
     * Stores object passed to current servlet by the <code>init</code> method.
     */
    private ServletContext context = null;

    /**
     * Encapsulates client request data.
     */
    private HttpServletRequest request = null;

    /**
     * Encapsulates application answer to the client.
     */
    private HttpServletResponse response = null;

    /**
     * Stores validation factory object to make validation processes.
     */
    private ValidatorFactory validatorFactory = null;

    /**
     * Initializes this class properties with values got from front servlet.
     * Also initializes validation factory using ServiceLocatorSingleton as container of services.
     *
     * @param pContext  is object which is gotten from the servlet's <code>ServletConfig</code> object.
     * @param pRequest  is object that is received from client request
     * @param pResponse is object that generated to be send as response to the client
     */
    public final void init(final ServletContext pContext, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
        setContext(pContext);
        setRequest(pRequest);
        setResponse(pResponse);
        setValidatorFactory((ValidatorFactory) ServiceLocatorSingleton.getInstance()
                .getService(ValidatorFactory.class));
    }

    /**
     * Executes the main business logic of the current command.
     *
     * @throws ServletException if there is something wrong with the servlet during forward() method call
     * @throws IOException      if there is something wrong with the IO during forward() method call
     */
    public abstract void execute() throws ServletException, IOException;

    /**
     * Forwards a request from a servlet to another resource (servlet, JSP file, or
     * HTML file) on the server. This method allows one servlet to do preliminary processing of
     * a request and another resource to generate the response.
     *
     * @param target page name to which request should be forwarded.
     * @throws ServletException if there is something wrong with the servlet during forward() method call
     * @throws IOException      if there is something wrong with the IO during forward() method call
     */
    public final void forward(final String target) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.context.getRequestDispatcher(target);
        dispatcher.forward(this.request, this.response);
    }

    /**
     * Gets parameter of the request by parameter's name.
     *
     * @param name contains name of the parameter, value is needed to get
     * @return value of the parameter.
     */
    public final String getParameter(final String name) {
        return getRequest().getParameter(name);
    }

    /**
     * Returns context of this class.
     *
     * @return context object of this class.
     */
    public final ServletContext getContext() {
        return this.context;
    }

    /**
     * Sets context.
     *
     * @param context is a context to be set.
     */
    public final void setContext(final ServletContext context) {
        this.context = context;
    }

    /**
     * Returns request.
     *
     * @return request object.
     */
    public final HttpServletRequest getRequest() {
        return this.request;
    }

    /**
     * Sets request.
     *
     * @param request is a request to be set.
     */
    public final void setRequest(final HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Returns response.
     *
     * @return response object.
     */
    public final HttpServletResponse getResponse() {
        return this.response;
    }

    /**
     * Sets responce.
     *
     * @param response is a response to be set.
     */
    public final void setResponse(final HttpServletResponse response) {
        this.response = response;
    }

    /**
     * Returns registered in this class validation factory.
     *
     * @return value of the validation factory.
     */
    public final ValidatorFactory getValidatorFactory() {
        return validatorFactory;
    }

    /**
     * Sets validation factory.
     *
     * @param validatorFactory is a validator factory to be set.
     */
    public final void setValidatorFactory(final ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    /**
     * Formats string to its canonicalized value. Removes leading and trailing whitespace
     * and then replacing sequences of whitespace characters by a single space.
     * In future canonicalize function could be spread to more complex things
     *
     * @param input is a value on which canonicalization should be processed.
     * @return canonicalized string.
     */
    public final String canonicalize(final String input) {
        String canonical = StringUtils.normalizeSpace(input);
        return canonical;
    }

    /**
     * Checks if income string is not empty (""), not null and not whitespace only(" ").
     *
     * @param parameterName is a value to check.
     * @return true if is not blank and false if blank.
     */
    public final Boolean isNotBlankField(final String parameterName) {
        String canonicalizedParameterValue = canonicalize(getParameter(parameterName));
        if (isNotBlank(canonicalizedParameterValue)) {
            return Boolean.TRUE;
        } else {
            getRequest().setAttribute(parameterName + "ErrorMessage", "Field: \"" + parameterName + "\", value: \""
                    + canonicalizedParameterValue + "\", message: \"should not be empty\"");
            return Boolean.FALSE;
        }
    }

    /**
     * Checks if income string has numeric format.
     *
     * @param parameterName is a value to check.
     * @return true if income string has numeric format.
     */
    public final Boolean isNumericFormat(final String parameterName) {
        String canonicalizedParameterValue = canonicalize(getParameter(parameterName));
        //getRequest().setAttribute(parameterName, canonicalizedParameterValue);
        if (isNumeric(canonicalizedParameterValue)) {
            return Boolean.TRUE;
        } else {
            getRequest().setAttribute(parameterName + "ErrorMessage", "Field: \"" + parameterName + "\", value: \""
                    + canonicalizedParameterValue + "\", message: \"should be numeric\"");
            return Boolean.FALSE;
        }
    }

    /**
     * Checks if income string has only Ascii printable characters (for example "Gï¿½lcï¿" is not Ascii printable).
     *
     * @param parameterName is a value to check.
     * @return true if income string has only Ascii printable characters.
     */
    public final Boolean isAsciiPrintableFormat(final String parameterName) {
        String canonicalizedParameterValue = canonicalize(getParameter(parameterName));
        //getRequest().setAttribute(parameterName, canonicalizedParameterValue);
        if (isAsciiPrintable(canonicalizedParameterValue)) {
            return Boolean.TRUE;
        } else {
            getRequest().setAttribute(parameterName + "ErrorMessage", "Field: \"" + parameterName + "\", value: \"\""
                    + canonicalizedParameterValue + "\", message: \"only Ascii printable characters are allowed\"");
            return Boolean.FALSE;
        }
    }

    /**
     * Validates value of the income property according to the rules - annotations in class "clazz".
     *
     * @param clazz    is used in validator() method (Bean Validation API). It specifies class where property is defined.
     * @param property is a property name, which should be validated.
     * @param value    is a value of the property, which should be validated.
     * @return size of constraint violations that happend to occur.
     * @throws Exception if exceptional situation is occur. Method validateValue() can throw IllegalArgumentException
     *                   if class Type is {@code null}, if {@code property} is {@code null}, empty or not a valid object property
     *                   or if {@code null} is passed to the varargs groups. Also ValidationException could be thrown by method
     *                   validateValue() if a non recoverable error happens during the validation process
     */
    public final Integer validateValue(final Class<T> clazz, final String property, final Object value) throws Exception {
        Validator validator = getValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validateValue(clazz, property, value);
        for (ConstraintViolation<T> cv : constraintViolations) {
            getRequest().setAttribute(cv.getPropertyPath() + "ErrorMessage", String.format("Field: \"%s\", value: \"%s\", message: \"%s\"",
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
        }
        return constraintViolations.size();
    }

    /**
     * Validates whole object of type T.
     *
     * @param object is an object to check.
     * @throws Exception (it could be IllegalArgumentException if object is {@code null}
     *                   or if {@code null} is passed to the varargs groups or ValidationException if a non recoverable error happens
     *                   during the validation process)
     */
    public final void validate(final T object) throws Exception {

        Validator validator = getValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        for (ConstraintViolation<T> cv : constraintViolations) {
            getRequest().setAttribute(cv.getPropertyPath() + "ErrorMessage", String.format("Field: \"%s\", value: \"%s\", message: \"%s\"",
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
        }
    }
}
