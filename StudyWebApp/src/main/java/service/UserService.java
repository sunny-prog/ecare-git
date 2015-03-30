package service;

import java.util.List;
import dao.UserDAO;
import daoImpl.UserDAOImpl;
import entity.User;

public class UserService {

    
    UserDAO dao = new UserDAOImpl();

    public List<User> getAll() {
        return dao.getAll();
    }

    public void delete(String email) {
        dao.delete(email);
    }
    
    
}
