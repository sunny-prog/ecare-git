package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;

import dao.UserDAO;
import daoImpl.UserDAOImpl;
import entity.User;

public class UserService {
	private EntityManager em = null;
	private ServletContext ctx = null;
	private UserDAO dao = null;

	public UserService(ServletContext ctx) {
		super();
		this.ctx = ctx;
		em = getEntityManager();
		dao = new UserDAOImpl();
		dao.setEntityManager(em);
	}

	protected void finalize() {
		em.close();
	}

	public List<User> getAll() {
		em.getTransaction().begin();
		List<User> userList = dao.getAll();
		em.getTransaction().commit();
		// em.close();
		return userList;
	}

	/**
	 * Find User based on the entity Id.
	 *
	 * @param userId
	 *            the user Id.
	 * @return User.
	 * @throws EntityNotFoundException
	 *             when no user is found.
	 */
	public User getUserById(Long userId) {
		User user = dao.getUserById(userId);
		return user;
	}

	public void delete(String email) {
		dao.delete(email);
	}

	/**
	 * Delete artist by their Id.
	 *
	 * @param artistId
	 *            the artist Id.
	 */
	public void deleteUserById(Long userId) {
		User user = em.find(User.class, userId);
		if (user == null) {
			throw new EntityNotFoundException("Can't find User for ID "
					+ userId);
		}
		em.getTransaction().begin();
		dao.delete(user);
		em.getTransaction().commit();
		// em.close();
	}

	public EntityManager getEntityManager() {
		// Obtain a database connection:
		EntityManagerFactory emf = (EntityManagerFactory) ctx
				.getAttribute("emf");

		EntityManager em = emf.createEntityManager();
		return em;
	}
}
