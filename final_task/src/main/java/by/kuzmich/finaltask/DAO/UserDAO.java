package by.kuzmich.finaltask.DAO;

import by.kuzmich.finaltask.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> selectAll () throws SQLException;
    void insert (User user) throws SQLException;
}
