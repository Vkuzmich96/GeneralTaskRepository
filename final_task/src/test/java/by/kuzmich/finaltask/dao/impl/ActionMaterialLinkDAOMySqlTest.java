package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.ActionMaterialLink;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ActionMaterialLinkDAOMySqlTest {
    private DAO<ActionMaterialLink, List<ActionMaterialLink>> dao;
    {
        try {
            dao = (ActionMaterialLinkDAOMySql) DAOFactory.getInstance().get(DAOKinds.ActionMaterialLinkDAOMySql, ConnectionPool.getInstance().getConnection());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private ActionMaterialLink link = new ActionMaterialLink(0,1, 1);
    private ActionMaterialLink linkUpdate = new ActionMaterialLink(0,2, 2);


    private ActionMaterialLink findLast() throws DAOException {
        List<ActionMaterialLink> list = dao.selectAll();
        return list.get(list.size() -1);
    }

    @Test
    public void insert() throws DAOException {
        int id = dao.insert(link);
        assertTrue(id != 0);
    }

    @Test
    public void selectAll() throws DAOException {
        assertFalse(dao.selectAll().isEmpty());
    }

    @Test
    public void select() throws DAOException {
        int id = findLast().getActionId();
        dao.select(String.valueOf(id));
        assertEquals(id, link.getActionId());
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
        linkUpdate.setId(id);
        dao.update(linkUpdate);
    }

}