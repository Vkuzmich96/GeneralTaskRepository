package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.exception.ServiceException;

public interface UserService {
    void add (User user) throws ServiceException;
    boolean checkPassword (User user) throws ServiceException;
    User get (String login) throws ServiceException;
    void update (User user) throws ServiceException;
}
