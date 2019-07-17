package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.bean.User;

import java.sql.SQLException;

public interface UserService {
    void add (User user) throws SQLException;
    boolean checkPassword (User user) throws SQLException;
}
