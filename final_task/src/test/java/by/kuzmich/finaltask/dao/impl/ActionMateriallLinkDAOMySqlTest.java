package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.ActionMaterialLink;
import by.kuzmich.finaltask.dao.utils.MySQLConnection;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ActionMateriallLinkDAOMySqlTest {
    private ActionMateriallLinkDAOMySql dao = new ActionMateriallLinkDAOMySql(MySQLConnection.getConnection());
    private ActionMaterialLink link = new ActionMaterialLink(0,1, 1);

    private ActionMaterialLink findFirst() throws SQLException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws SQLException {
        int sizeBefore = dao.selectAll().size();
        dao.insert(link);
        int sizeAfter = dao.selectAll().size();
        assertEquals(sizeBefore + 1, sizeAfter);    }

    @Test
    public void selectAll() throws SQLException {
        assertFalse(dao.selectAll().isEmpty());
    }

    @Test
    public void select() throws SQLException {
        int id = findFirst().getActionId();
        dao.select(id);
        assertEquals(id, link.getActionId());
    }

    @Test(expected = SQLException.class)
    public void delete() throws SQLException {
        int id  = findFirst().getId();
        dao.delete(id);
        dao.select(id);
    }

    @Test
    public void updateAction() throws SQLException {
        int id  = findFirst().getId();
        dao.updateAction(2, id);
        ActionMaterialLink link = dao.select(id).get(0);
        assertEquals(2, link.getActionId());
    }

    @Test
    public void updateMaterial() throws SQLException {
        int id  = findFirst().getId();
        dao.updateMaterial(2, id);
        ActionMaterialLink link = dao.select(id).get(0);
        assertEquals(2, link.getActionId());
    }
}