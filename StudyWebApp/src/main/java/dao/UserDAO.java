package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entity.User;

public interface UserDAO {
	User getUserByEmail(String email);
	User getUserById(Long userId);
    boolean delete(String email);
    boolean add(User user);
    List<User> getAll();
	void setEntityManager(EntityManager em);
	boolean delete(User user);
}
