package by.kuzmich.finaltask.dao;

import by.kuzmich.finaltask.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends DAO<User> {
    void insert (User user) throws SQLException;
    List<User> selectAll () throws SQLException;
    User select(int id) throws SQLException;
    void delete (int id) throws SQLException;
    void updateEmail (String value, int id) throws SQLException;
    void updatePassword (String value, int id) throws SQLException;
    void updateRole (int value, int id) throws SQLException;
    void updateName (String value, int id) throws SQLException;
    void updateAddress (String value, int id) throws SQLException;
    void updatePhone (Long value, int id) throws SQLException;
}
