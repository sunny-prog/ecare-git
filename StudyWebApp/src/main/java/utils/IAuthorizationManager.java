package utils;

import entity.User;

/**
 * Manages authorization to the system.
 *
 * @author Tatiana
 * @version 1.0
 */
public interface IAuthorizationManager {
    /**
     * Returns boolean indicating whether user has the appropriate role
     * for the specified URI.
     *
     * @param user is the user be initialized
     * @param uri  unified resource identifier
     * @return boolean true if user is authorized
     */
    boolean isUserAuthorized(User user, String uri);

}
