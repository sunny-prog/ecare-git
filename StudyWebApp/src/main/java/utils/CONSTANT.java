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
    private CONSTANT() {
    }

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

    /**
     * Option title maximum length.
     */
    public static final int OPTION_TITLE_MAX_LENGTH = 15;

    /**
     * Option price maximum value.
     */
    public static final int OPTION_PRICE_MAX_VALUE = 1000;

    /**
     * Option price minimum value.
     */
    public static final int OPTION_PRICE_MIN_VALUE = 10;

    /**
     * Option activation cost maximum value.
     */
    public static final int OPTION_ACTIVATION_COST_MAX_VALUE = 500;

    /**
     * Option activation cost maximum value.
     */
    public static final int TARIFF_TITLE_MAX_LENGTH = 15;

    /**
     * Option activation cost maximum value.
     */
    public static final int CONTRACT_NUMBER_MAX_LENGTH = 10;

    /**
     * Stores path to the resources folder. This folder contains important files,
     * needed during development process(eCare_checks_SunBased.xml, for example).
     */
    public static final String RESOURCES_DIRECTORY_PATH =
            "c:\\Users\\Tatiana\\Documents\\projects\\IdeaProjects\\ecare-git\\StudyWebApp\\src\\main\\resources\\";
    /**
     * Stores the name of the role, if user of the application plays role of salesman.
     * Salesman is a man who can run new contracts, create new users with client role.
     * Process options rules.
     */
    public static final String SALESMAN_ROLE_NAME = "SALESMAN";
    /**
     * Stores the name of the role, if user of the application plays role of client.
     * Client is a person who had one or more contracts in eCare shop.
     */
    public static final String CLIENT_ROLE_NAME = "CLIENT";

    /**
     * Stores path to the client welcome page.
     */
    public static final String CLIENT_WELCOME_PAGE = "/views/restricted/client/client.jsp";

    /**
     * Stores path to the salesman welcome page.
     */
    public static final String SALESMAN_WELCOME_PAGE = "/views/restricted/salesman/salesman.jsp";
}
