package service;

import java.util.List;
import entity.User;

public interface IUserService {

	public List<User> getAll();

	public User getUserById(Long userId);

	public void deleteUserById(Long userId);
}
