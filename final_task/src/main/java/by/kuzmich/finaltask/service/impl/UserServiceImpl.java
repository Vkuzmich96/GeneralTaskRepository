package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.service.UserService;

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
        return user.equals(userDB);
    }

    public User get (String login) throws SQLException {
        return dao.select(login);
    }
}
