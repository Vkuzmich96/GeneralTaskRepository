package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.DAO;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private DAO<User, User> dao;

    public UserServiceImpl(DAO<User, User> dao) {
        this.dao = dao;
    }

    public void add (User user) throws SQLException {
         dao.insert(user);
    }

    public boolean checkPassword (User user) throws SQLException {
         User userDB = dao.select(user.getEmail());
         String userDBPassword = userDB.getPassword();
         return user.getPassword().equals(userDBPassword);
    }

    public User find (String email) throws SQLException {
        return dao.select(email);
    }
}
