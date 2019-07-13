package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.utils.MySQLConnection;
import by.kuzmich.finaltask.bean.LawMapName;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class LawMapNameDAOMySqlTest {
    private LawMapNameDAOMySql dao = new LawMapNameDAOMySql(MySQLConnection.getConnection());
    private LawMapName lawMapName = new LawMapName(0,"loren ipsum");

    private LawMapName findFirst() throws SQLException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws SQLException {
        int sizeBefore = dao.selectAll().size();
        dao.insert(lawMapName);
        int sizeAfter = dao.selectAll().size();
        assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    public void selectAll() throws SQLException {
        int size = dao.selectAll().size();
        assertTrue(size>=4);
    }

    @Test
    public void select() throws SQLException{
        int id = findFirst().getId();
        LawMapName lawMapName = dao.select(id);
        assertEquals(id, lawMapName.getId());
    }

    @Test(expected = SQLException.class)
    public void delete() throws SQLException {
        int id  = findFirst().getId();
        dao.delete(id);
        dao.select(id);
    }
}