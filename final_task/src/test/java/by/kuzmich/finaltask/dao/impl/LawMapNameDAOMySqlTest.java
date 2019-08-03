package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.bean.LawMapName;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.exception.ServiceException;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class LawMapNameDAOMySqlTest {
    private DAO<LawMapName, LawMapName> dao;

    {
        try {
            dao = (LawMapNameDAOMySql) DAOFactory.getInstance().get(DAOKinds.LawMapNameDAOMySql, ConnectionPool.getInstance().getConnection());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private LawMapName lawMapName = new LawMapName(0,"loren ipsum", false);
    private LawMapName lawMapNameUpdate = new LawMapName(0,"just a test", true);


    private LawMapName findFirst() throws DAOException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws DAOException {
        int id = dao.insert(lawMapName);
        dao.select(String.valueOf(id));
    }

    @Test
    public void selectAll() throws DAOException {
        int size = dao.selectAll().size();
        assertTrue(size>=4);
    }

    @Test
    public void select() throws DAOException{
        int id = findFirst().getId();
        LawMapName lawMapName = dao.select(String.valueOf(id));
        assertEquals(id, lawMapName.getId());
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
        lawMapNameUpdate.setId(id);
        dao.update(lawMapNameUpdate);
    }
}