package utils;

/**
 * Created by Tatiana on 09.07.2015.
 */
public class eCareAppException extends Exception {


    private String errorMessage = null;



    private StackTraceElement[] stackTrace = null;

    public eCareAppException() {
        super();
    }

    public eCareAppException(String message) {
        super(message);
        this.errorMessage = message;
    }
    public eCareAppException(String message, StackTraceElement[] stackTrace) {
        super(message);
        this.errorMessage = message;
        setStackTrace(stackTrace);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }
}
