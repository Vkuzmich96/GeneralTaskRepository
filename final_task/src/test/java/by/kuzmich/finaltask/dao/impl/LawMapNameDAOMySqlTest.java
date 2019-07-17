package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.bean.LawMapName;
import by.kuzmich.finaltask.exception.DAOException;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class LawMapNameDAOMySqlTest {
    private DAO<LawMapName, LawMapName> dao;

    {
        try {
            dao = (LawMapNameDAOMySql) DAOFactory.getInstance().get(DAOKinds.LawMapNameDAOMySql);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private LawMapName lawMapName = new LawMapName(0,"loren ipsum");
    private LawMapName lawMapNameUpdate = new LawMapName(0,"just a test");


    private LawMapName findFirst() throws SQLException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws SQLException {
        int id = dao.insert(lawMapName);
        dao.select(String.valueOf(id));
    }

    @Test
    public void selectAll() throws SQLException {
        int size = dao.selectAll().size();
        assertTrue(size>=4);
    }

    @Test
    public void select() throws SQLException{
        int id = findFirst().getId();
        LawMapName lawMapName = dao.select(String.valueOf(id));
        assertEquals(id, lawMapName.getId());
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
        lawMapNameUpdate.setId(id);
        dao.update(lawMapNameUpdate);
    }
}