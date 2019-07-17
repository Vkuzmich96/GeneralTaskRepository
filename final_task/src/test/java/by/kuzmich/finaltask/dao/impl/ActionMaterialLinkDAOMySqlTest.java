package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.ActionMaterialLink;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.exception.DAOException;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ActionMaterialLinkDAOMySqlTest {
    private DAO<ActionMaterialLink, List<ActionMaterialLink>> dao;
    {
        try {
            dao = (ActionMaterialLinkDAOMySql) DAOFactory.getInstance().get(DAOKinds.ActionMaterialLinkDAOMySql);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private ActionMaterialLink link = new ActionMaterialLink(0,1, 1);
    private ActionMaterialLink linkUpdate = new ActionMaterialLink(0,2, 2);


    private ActionMaterialLink findFirst() throws SQLException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws SQLException {
        int id = dao.insert(link);
        dao.select(String.valueOf(id));
    }

    @Test
    public void selectAll() throws SQLException {
        assertFalse(dao.selectAll().isEmpty());
    }

    @Test
    public void select() throws SQLException {
        int id = findFirst().getActionId();
        dao.select(String.valueOf(id));
        assertEquals(id, link.getActionId());
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
        linkUpdate.setId(id);
        dao.update(linkUpdate);
    }

}