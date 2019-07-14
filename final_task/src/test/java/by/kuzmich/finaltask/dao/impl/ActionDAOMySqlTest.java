package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.DAOMySqlFactory;
import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.exception.DAOException;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ActionDAOMySqlTest {
    private DAO<Action, Action> dao;

    {
        try {
            dao = (ActionDAOMySql) DAOMySqlFactory.getInstance().get(DAOKinds.ActionDAOMySql);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private Action action = new Action(0,"loren ipsum", null, null);
    private User user = new User(11,"11", "password", Role.USER,"11","1",11);
    private Action actionUpdate = new Action(0,"just a test", null, user);

    private Action findFirst() throws SQLException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws SQLException {
        int id = dao.insert(action);
        dao.select(id);
    }

    @Test
    public void selectAll() throws SQLException {
        assertFalse(dao.selectAll().isEmpty());
    }

    @Test
    public void select() throws SQLException {
        int id = findFirst().getId();
        Action action = dao.select(id);
        assertEquals(id, action.getId());
    }

    @Test(expected = SQLException.class)
    public void delete() throws SQLException {
        int id  = findFirst().getId();
        dao.delete(id);
        dao.select(id);
    }

    @Test
    public void update() throws SQLException {
        int id  = findFirst().getId();
        actionUpdate.setId(id);
        dao.update(actionUpdate);
    }
}