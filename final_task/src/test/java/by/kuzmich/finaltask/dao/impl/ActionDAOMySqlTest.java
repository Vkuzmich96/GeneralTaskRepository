package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.utils.MySQLConnection;
import by.kuzmich.finaltask.bean.Action;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ActionDAOMySqlTest {
    private ActionDAOMySql dao = new ActionDAOMySql(MySQLConnection.getConnection());
    private Action action = new Action(0,"loren ipsum", null, null);

    private Action findFirst() throws SQLException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws SQLException {
        int sizeBefore = dao.selectAll().size();
        dao.insert(action);
        int sizeAfter = dao.selectAll().size();
        assertEquals(sizeBefore + 1, sizeAfter);
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
    public void updateInstructions() throws SQLException {
        int id  = findFirst().getId();
        dao.updateInstructions("just a test", id);
        Action action = dao.select(id);
        assertEquals("just a test", action.getInstructions());
    }

    @Test
    public void updateUserId() throws SQLException {
        int id  = findFirst().getId();
        dao.updateUserId(7, id);
    }
}