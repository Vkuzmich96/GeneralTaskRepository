package by.kuzmich.finaltask.dao;

import by.kuzmich.finaltask.exception.DAOException;

import java.util.List;

public  interface DAO <T, S> {
    int insert (T object) throws DAOException;
    List<T> selectAll() throws DAOException;
    S select(String key) throws DAOException;
    void delete (int id) throws DAOException;
    void update (T name) throws DAOException;
}
