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
    private String stackTraceText = null;

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
     * @param message        message to store in this class property "message".
     * @param stackTraceText stores stack trace of the exception.
     */
    public ECareAppException(final String message, final String stackTraceText) {
        super(message);
        this.errorMessage = message;
        setStackTraceText(stackTraceText);
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
     * @return {@link String}
     */
    public final String getStackTraceText() {
        return stackTraceText;
    }

    /**
     * Sets the stack trace.
     *
     * @param stackTrace allowed object is {@link String}
     */

    public final void setStackTraceText(final String stackTrace) {
        this.stackTraceText = stackTraceText;
    }
}
