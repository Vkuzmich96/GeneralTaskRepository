package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.exception.ExceptionMessageList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.UserService;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private DAO<User, User> dao;

    public UserServiceImpl(DAO<User, User> dao) {
        this.dao = dao;
    }

    /**
     * Adds an new User to DAO
     */
    public void add (User user) throws ServiceException {
        try {
            dao.insert(user);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    /**
     * Checks a User password
     */
    public boolean checkPassword (User user) throws ServiceException {
        try {
            User userDB = dao.select(user.getEmail());
            return user.equals(userDB);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    /**
     * Gets an User from DAO by login
     */
    public User get (String login) throws ServiceException {
        try {
            return dao.select(login);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    /**
     * Updates an User
     */
    public void update (User user) throws ServiceException {
        try {
            dao.update(user);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }
}
