package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import entity.User;

public class UserDAOImpl implements UserDAO {

	private static List<User> users;

	static {
		users = new ArrayList<User>();
		users.add(new User("Jon", "jon@email.com", Integer.valueOf(23)));
		users.add(new User("Ben", "ben@email.com", Integer.valueOf(17)));
		users.add(new User("Ann", "ann@email.com", Integer.valueOf(22)));
		users.add(new User("Jen", "jen@email.com", Integer.valueOf(25)));
		users.add(new User("Ron", "ron@email.com", Integer.valueOf(31)));
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
	public List<User> getAll() {
		return users;
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
	public boolean add(User user) {
		return users.add(user);
	}

}
