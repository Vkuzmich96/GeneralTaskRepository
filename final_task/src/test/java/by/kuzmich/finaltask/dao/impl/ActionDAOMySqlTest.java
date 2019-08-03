package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ActionDAOMySqlTest {
    private DAO<Action, Action> dao;

    {
        try {
            dao = (ActionDAOMySql) DAOFactory.getInstance().get(DAOKinds.ActionDAOMySql, ConnectionPool.getInstance().getConnection());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private Action action = new Action(0,"loren ipsum", "loren ipsum", null, new User (1));
    private Action actionUpdate = new Action(2,"just a test", "just a test", null, new User (2));

    private Action findFirst() throws DAOException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws DAOException {
        int id = dao.insert(action);
        dao.select(String.valueOf(id));
    }

    @Test
    public void selectAll() throws DAOException {
        assertFalse(dao.selectAll().isEmpty());
    }

    @Test
    public void select() throws DAOException {
        int id = findFirst().getId();
        Action action = dao.select(String.valueOf(id));
        assertEquals(id, action.getId());
    }

    @Test(expected = DAOException.class)
    public void delete() throws DAOException {
        int id  = findFirst().getId();
        dao.delete(id);
        dao.select(String.valueOf(id));
    }

    @Test
    public void update() throws DAOException {
        int id  = findFirst().getId();
        actionUpdate.setId(id);
        dao.update(actionUpdate);
    }
}