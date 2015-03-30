package dao;

import java.util.List;
import entity.User;

public interface UserDAO {

    User getUserByEmail(String email);
    boolean delete(String email);
    boolean add(User user);
    List<User> getAll();
}
