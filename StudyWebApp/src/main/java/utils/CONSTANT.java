package utils;

/**
 * Stores constants used all over application.
 *
 * @author Tatiana
 * @version 1.0
 */
public final class CONSTANT {
    /**
     * Private constructor, as it should not be possible to create an instance.
     * As no instance is needed to use this constructor's static members.
     */
    private CONSTANT() {  }

    /**
     * User surname maximum length.
     */
    public static final int USER_SURNAME_MAX_LENGTH = 50;

    /**
     * User name maximum length.
     */
    public static final int USER_NAME_MAX_LENGTH = 20;

    /**
     * User passport maximum length.
     */
    public static final int USER_PASSPORT_MAX_LENGTH = 10;

    /**
     * User address maximum length.
     */
    public static final int USER_ADDRESS_MAX_LENGTH = 256;

    /**
     * User password maximum length.
     */
    public static final int USER_PASSWORD_MAX_LENGTH = 256;
}
