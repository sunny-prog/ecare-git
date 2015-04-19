package daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import dao.UserDAO;
import entity.User;

public class UserDAOImpl implements UserDAO {

	private static List<User> users;
	EntityManager em = null;

	static {
		users = new ArrayList<User>();
		users.add(new User(Long.valueOf(1), "Jon", "Tavolta", "jon@email.com",
				Integer.valueOf(23)));
		users.add(new User(Long.valueOf(2), "Ben", "Aflek", "ben@email.com",
				Integer.valueOf(17)));
	}

	@Override
	public User getUserByEmail(String email) {
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getUserById(Long userId) {
		User user = em.find(User.class, userId);
	        if (user == null) {
	            throw new EntityNotFoundException("Can't find User for ID "
	                    + userId);
	        }
	        return user;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		Query query = em.createQuery("SELECT u FROM User u");
		return (List<User>) query.getResultList();
	}

	@Override
	public boolean delete(String email) {
		User userToRemove = null;
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				userToRemove = user;
				break;
			}
		}
		if (userToRemove != null) {
			return users.remove(userToRemove);
		}
		return false;
	}
	
	@Override
	public boolean delete(User user) {
		return users.remove(user);
	}

	@Override
	public boolean add(User user) {
		return users.add(user);
	}

	public EntityManager getEm() {
		return em;
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
