package service;

import entity.User;
import utils.ECareAppException;

/**
 * Provides the interface for the User service. Extends all CRUD operations from the generic BaseService interface.
 *
 * @author Tatiana
 * @version 1.0
 */
public interface IUserService extends BaseService<User> {
    /**
     * Returns the user by email.
     *
     * @param email as criteria to search among users
     * @return the user
     * @throws ECareAppException if errors during processing is detected
     */
    User getUserByEmail(final String email) throws ECareAppException;
}
