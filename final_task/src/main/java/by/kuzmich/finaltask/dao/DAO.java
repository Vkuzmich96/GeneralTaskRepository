package by.kuzmich.finaltask.dao;

import java.sql.SQLException;
import java.util.List;

public  interface DAO <T> {
    void insert (T object) throws SQLException;
    List<T> selectAll() throws SQLException;
    T select(int id) throws SQLException;
    void delete (int id) throws SQLException;
}
