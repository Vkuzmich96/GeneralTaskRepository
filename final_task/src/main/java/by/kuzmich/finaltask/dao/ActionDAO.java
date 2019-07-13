package by.kuzmich.finaltask.dao;

import by.kuzmich.finaltask.bean.Action;

import java.sql.SQLException;
import java.util.List;

public interface ActionDAO {
    void insert (Action action) throws SQLException;
    List<Action> selectAll() throws SQLException;
    Action select(int id) throws SQLException;
    void delete (int id) throws SQLException;
    void updateInstructions (String value, int id) throws SQLException;
    void updateUserId (int value, int id) throws SQLException;
}
