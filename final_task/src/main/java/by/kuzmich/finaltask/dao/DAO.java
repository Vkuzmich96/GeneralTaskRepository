package by.kuzmich.finaltask.dao;

import java.sql.SQLException;
import java.util.List;

public  interface DAO <T, S> {
    int insert (T object) throws SQLException;
    List<T> selectAll() throws SQLException;
    S select(int id) throws SQLException;
    void delete (int id) throws SQLException;
    void update (T name) throws SQLException;
}
