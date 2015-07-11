package utils;

/**
 * Created by Tatiana on 09.07.2015.
 */
public class ECareAppException extends Exception {

    /**
     * Message that contains error.
     */
    private String errorMessage = null;


    /**
     * Contains stack trace of the exception.
     */
    private StackTraceElement[] stackTrace = null;

    /**
     * Class constructor.
     */
    public ECareAppException() {
        super();
    }

    /**
     * One more class constructor.
     *
     * @param message passes message to initialize this class message.
     */
    public ECareAppException(final String message) {
        super(message);
        this.errorMessage = message;
    }

    /**
     * One more constructor with two parameters.
     *
     * @param message    message to store in this class property "message".
     * @param stackTrace stores stack trace of the exception.
     */
    public ECareAppException(final String message, final StackTraceElement[] stackTrace) {
        super(message);
        this.errorMessage = message;
        setStackTrace(stackTrace);
    }

    /**
     * Gets the error message.
     *
     * @return {@link String}
     */
    public final String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the error message.
     *
     * @param errorMessage allowed object is {@link String}
     */
    public final void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Gets the stack trace.
     *
     * @return {@link StackTraceElement[]}
     */
    @Override
    public final StackTraceElement[] getStackTrace() {
        return stackTrace;
    }

    /**
     * Sets the stack trace.
     *
     * @param stackTrace allowed object is {@link StackTraceElement[]}
     */
    @Override
    public final void setStackTrace(final StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }
}
