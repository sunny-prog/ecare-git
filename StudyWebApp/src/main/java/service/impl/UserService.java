package service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import service.IUserService;
import entity.User;

public class UserService implements IUserService {
	private EntityManagerFactory emf = null;

	public UserService(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u FROM User u");
		List<User> users = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return users;
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
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, userId);
		if (user == null) {
			throw new EntityNotFoundException("Can't find User for ID "
					+ userId);
		}
		em.getTransaction().commit();
		em.close();
		return user;
	}

	/**
	 * Delete artist by their Id.
	 *
	 * @param artistId
	 *            the artist Id.
	 */
	public void deleteUserById(Long userId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, userId);
		if (user == null) {
			throw new EntityNotFoundException("Can't find User for ID "
					+ userId);
		}
		em.remove(user);
		em.getTransaction().commit();
		em.close();
	}
}
