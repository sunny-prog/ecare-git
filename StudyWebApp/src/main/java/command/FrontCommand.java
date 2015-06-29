package command;

import org.apache.commons.lang3.StringUtils;
import service.IContractService;
import utils.ServiceLocatorSingleton;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;

import static org.apache.commons.lang3.StringUtils.isAsciiPrintable;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public abstract class FrontCommand<T> {
    private ServletContext context = null;
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private ValidatorFactory validatorFactory = null;

    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        setContext(context);
        setRequest(request);
        setResponse(response);
        setValidatorFactory((ValidatorFactory) ServiceLocatorSingleton.getInstance()
                .getService(ValidatorFactory.class));
    }

    public abstract void execute() throws ServletException, IOException;

    public void forward(String target) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.context.getRequestDispatcher(target);
        dispatcher.forward(this.request, this.response);
    }

    public String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    public ServletContext getContext() {
        return this.context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    public HttpServletRequest getRequest() {
        return this.request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return this.response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public ValidatorFactory getValidatorFactory() {
        return validatorFactory;
    }

    public void setValidatorFactory(ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
    }

    // In future canonicalize function could be spread to more complex things
    public String canonicalize(String input) {

        String canonical = StringUtils.normalizeSpace(input);
        return canonical;
    }

    public Boolean isNotBlankField(String parameterName) {
        String canonicalizedParameterValue = canonicalize(getParameter(parameterName));
        //getRequest().setAttribute(parameterName, canonicalizedParameterValue);
        if (isNotBlank(canonicalizedParameterValue)) {
            return Boolean.TRUE;
        } else {
            getRequest().setAttribute(parameterName + "ErrorMessage", "Field: \"" + parameterName + "\", value: \"" + canonicalizedParameterValue + "\", message: \"should not be empty\"");
            return Boolean.FALSE;
        }
    }

    public Boolean isNumericFormat(String parameterName) {
        String canonicalizedParameterValue = canonicalize(getParameter(parameterName));
        //getRequest().setAttribute(parameterName, canonicalizedParameterValue);
        if (isNumeric(canonicalizedParameterValue)) {
            return Boolean.TRUE;
        } else {
            getRequest().setAttribute(parameterName + "ErrorMessage", "Field: \"" + parameterName + "\", value: \"" + canonicalizedParameterValue + "\", message: \"should be numeric\"");
            return Boolean.FALSE;
        }
    }

    // For example "Gï¿½lcï¿" is not Ascii printable
    public Boolean isAsciiPrintableFormat(String parameterName) {
        String canonicalizedParameterValue = canonicalize(getParameter(parameterName));
        //getRequest().setAttribute(parameterName, canonicalizedParameterValue);
        if (isAsciiPrintable(canonicalizedParameterValue)) {
            return Boolean.TRUE;
        } else {
            getRequest().setAttribute(parameterName + "ErrorMessage", "Field: \"" + parameterName + "\", value: \"\"" + canonicalizedParameterValue + "\", message: \"only Ascii printable characters are allowed\"");
            return Boolean.FALSE;
        }
    }


    public Integer validateValue(Class<T> clazz, String property, Object value) throws Exception {
        Validator validator = getValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validateValue(clazz, property, value);
        for (ConstraintViolation<T> cv : constraintViolations) {
            getRequest().setAttribute(cv.getPropertyPath() + "ErrorMessage", String.format("Field: \"%s\", value: \"%s\", message: \"%s\"",
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
        }
        return constraintViolations.size();
    }

    public void validate(T object) throws Exception {

        Validator validator = getValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        for (ConstraintViolation<T> cv : constraintViolations) {
            getRequest().setAttribute(cv.getPropertyPath() + "ErrorMessage", String.format("Field: \"%s\", value: \"%s\", message: \"%s\"",
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
        }
    }
}