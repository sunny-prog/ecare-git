package service.impl;

import entity.User;
import service.IUserService;

import javax.persistence.EntityManagerFactory;
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
	 * @param emf entity manager factory
	 */
	public UserService(final EntityManagerFactory emf) {
		super(User.class, emf);
		this.emf = emf;
	}
}
