package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDAOMySqlTest {
    private DAO<User, User> dao;

    {
        try {
            dao = (UserDAOMySql) DAOFactory.getInstance().get(DAOKinds.UserDAOMySql, ConnectionPool.getInstance().getConnection());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private User user = new User(11,"11", "password", Role.USER,"11","1",11);
    private User userUpdate = new User(4,"22", "test ", Role.USER,"22","zczxc2",222324234L);


    private User findLast() throws DAOException {
        List<User> list = dao.selectAll();
        return list.get(list.size() -1);
    }

    @Test
    public void insert() throws DAOException {
        int id = dao.insert(user);
        assertTrue(id != 0);
    }

    @Test
    public void selectAll() throws DAOException {
        assertFalse(dao.selectAll().isEmpty());
    }

    @Test
    public void select() throws DAOException {
        int id = findLast().getId();
        User user = dao.select(String.valueOf(id));
        assertNotNull(user);
    }

    @Test(expected = DAOException.class)
    public void delete() throws DAOException {
        int id  = findLast().getId();
        dao.delete(id);
        dao.select(String.valueOf(id));
    }

   @Test
    public void update() throws DAOException {
        int id  = findLast().getId();
        userUpdate.setId(id);
        dao.update(userUpdate);
    }
}