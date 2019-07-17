package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.exception.DAOException;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDAOMySqlTest {
    private DAO<User, User> dao;

    {
        try {
            dao = (UserDAOMySql) DAOFactory.getInstance().get(DAOKinds.UserDAOMySql);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private User user = new User(11,"11", "password", Role.USER,"11","1",11);
    private User userUpdate = new User(4,"22", "test ", Role.USER,"22","zczxc2",222324234L);


    private User findFirst() throws SQLException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws SQLException {
        int id = dao.insert(user);
        dao.select(String.valueOf(id));
    }

    @Test
    public void selectAll() throws SQLException {
        assertFalse(dao.selectAll().isEmpty());
    }

    @Test
    public void select() throws SQLException {
        int id = findFirst().getId();
        User user = dao.select(String.valueOf(id));
        assertEquals(id, user.getId());
    }

    @Test(expected = SQLException.class)
    public void delete() throws SQLException {
        int id  = findFirst().getId();
        dao.delete(id);
        dao.select(String.valueOf(id));
    }

   @Test
    public void update() throws SQLException {
        int id  = findFirst().getId();
        userUpdate.setId(id);
        dao.update(userUpdate);
    }
}