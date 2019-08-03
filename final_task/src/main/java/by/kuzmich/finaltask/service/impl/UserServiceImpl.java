package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.exception.ExceptionMessageList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.UserService;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(MapServiceImpl.class);
    private DAO<User, User> dao;

    public UserServiceImpl(DAO<User, User> dao) {
        this.dao = dao;
    }

    public void add (User user) throws ServiceException {
        try {
            dao.insert(user);
        } catch (DAOException e) {
            logger.error(ExceptionMessageList.UNABLE_TO_DATA_ACCESS);
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_DATA_ACCESS);
        }
    }

    public boolean checkPassword (User user) throws ServiceException {
        try {
            User userDB = dao.select(user.getEmail());
            return user.equals(userDB);
        } catch (DAOException e) {
            logger.error(ExceptionMessageList.UNABLE_TO_DATA_ACCESS);
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_DATA_ACCESS);
        }
    }

    public User get (String login) throws ServiceException {
        try {
            return dao.select(login);
        } catch (DAOException e) {
            logger.error(ExceptionMessageList.UNABLE_TO_DATA_ACCESS);
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_DATA_ACCESS);
        }
    }

    public void update (User user) throws ServiceException {
        try {
            dao.update(user);
        } catch (DAOException e) {
            logger.error(ExceptionMessageList.UNABLE_TO_DATA_ACCESS);
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_DATA_ACCESS);
        }
    }
}
