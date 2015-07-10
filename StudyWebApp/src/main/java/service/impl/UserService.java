package service.impl;

import entity.User;
import service.IUserService;
import utils.eCareAppException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Provides the local service for creating, reading, updating, deleting (CRUD) users.
 *
 * @author Tatiana
 * @version 1.0
 */
public class UserService extends AbstractCRUDService<User> implements IUserService {
    /**
     * Entity manager factory that is initialized during application start-up {@link utils.ServiceLocatorSingleton#getInstance()}.
     */
    private EntityManagerFactory emf = null;

    /**
     * Class constructor.
     *
     * @param emf entity manager factory
     */
    public UserService(final EntityManagerFactory emf) {
        super(User.class, emf);
        this.emf = emf;
    }

    /**
     * Returns the entity of type User by email.
     *
     * @param email stores email of the user
     * @return the user
     */
    public final User getUserByEmail(final String email) throws eCareAppException {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("Select u FROM User u WHERE u.email = :email");
        query.setParameter("email", email);
        User result = null;
        try {
            result = (User) query.getSingleResult();
        } catch (NoResultException ex) {
            throw new eCareAppException(ex.getMessage(),ex.getStackTrace());
        }

        em.close();
        return result;
    }
}
