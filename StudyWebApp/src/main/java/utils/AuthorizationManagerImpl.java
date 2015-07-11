package utils;

import entity.User;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * Manages authorization to the system.
 *
 * @author Tatiana
 * @version 1.0
 */
public class AuthorizationManagerImpl implements IAuthorizationManager {

    /**
     * Contains role mappings.
     */
    private Properties roleMappings;

    /**
     * Load mappings from a properties file on the file system.
     */
    public AuthorizationManagerImpl() {
        //Read in properties file containing role mappings...
        roleMappings = new Properties();
        try {
            // String realPath = context.getRealPath("/resources");
            // String pathToMappingProps = realPath + System.getProperty("file.separator") + "mapping.properties";

            FileInputStream fis = (new FileInputStream(CONSTANT.RESOURCES_DIRECTORY_PATH + "mapping.properties"));
            // Property "file.separator" stores system separator of the files
            roleMappings.load(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns boolean indicating whether user has the appropriate role
     * for the specified URI.
     *
     * @param user is the user be initialized
     * @param uri  unified resource identifier
     * @return boolean true if user is authorized
     */
    public final boolean isUserAuthorized(final User user, final String uri) {

        boolean matchFound = false;
        boolean authorized = false;

        Iterator i = roleMappings.entrySet().iterator();

        //Loop through each URI mapping and check user's roles.
        //Exit once match is found.
        while ((!authorized) && (i.hasNext())) {
            Map.Entry me = (Map.Entry) i.next();

            //Pattern match.  '*' should be interpreted as a wildcard
            //for any ASCII character.
            String mapPattern =
                    ((String) me.getValue()).replaceAll("\\*", ".*");
            matchFound = Pattern.matches(mapPattern, uri);

            String mappingRole = AuthorizationManagerImpl.removeLastChar((String) me.getKey());
            if (matchFound && user.getRole().equals(mappingRole)) {
                authorized = true;
                return authorized;
            }
        }
        return authorized;
    }

    /**
     * Util fast function that removes two last
     * characters from the string that is past as parameter.
     *
     * This function is needed because in the file mappings.properties
     * roles are written with additional two symbols "_" and counting digit. For example,
     * SALESMAN_1 or CLIENT_3. This was done because properties should
     * have different names for load() method usage.
      *
     * @param str string to be modified
     * @return modofied string (without two last characters)
     */
    private static String removeLastChar(final String str) {
        return str.substring(0, str.length() - 2);
    }
}
