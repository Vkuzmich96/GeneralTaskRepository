package by.kuzmich.finaltask.DAO.impl;

import by.kuzmich.finaltask.DAO.utils.MySQLConnection;
import by.kuzmich.finaltask.bean.Action;
import org.junit.After;
import org.junit.AfterClass;
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

    @Before
    public void filler() throws SQLException {
        dao.insert(action);
        dao.insert(action);
        dao.insert(action);
        dao.insert(action);
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
        int size = dao.selectAll().size();
        assertTrue(size>=4);
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
        dao.updateUserId(1, id);
    }

    @After
    public void cleaner() throws SQLException {
        List<Action> actions = dao.selectAll();
        for(Action action: actions){
            dao.delete(action.getId());
        }
    }
}