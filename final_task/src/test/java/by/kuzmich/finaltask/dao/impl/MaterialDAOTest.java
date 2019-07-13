package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.utils.MySQLConnection;
import by.kuzmich.finaltask.bean.Material;
import static org.junit.Assert.*;


import org.junit.Test;

import java.sql.SQLException;


public class MaterialDAOTest {
    private MaterialDAOMySql dao = new MaterialDAOMySql(MySQLConnection.getConnection());
    private Material material = new Material(0, "jdbc.properties", "lorem ipsum");

    private Material findFirst() throws SQLException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws SQLException {
        int sizeBefore = dao.selectAll().size();
        dao.insert(material);
        int sizeAfter = dao.selectAll().size();
        assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    public void selectAll() throws SQLException{
        assertFalse(dao.selectAll().isEmpty());
    }

    @Test
    public void select() throws SQLException {
        int id = findFirst().getId();
        Material material = dao.select(id);
        assertEquals(id, material.getId());
    }

    @Test(expected = SQLException.class)
    public void delete() throws SQLException {
        int id  = findFirst().getId();
        dao.delete(id);
        dao.select(id);
    }

    @Test
    public void updateUrl() throws SQLException {
        int id  = findFirst().getId();
        dao.updateUrl("just a test", id);
        Material material = dao.select(id);
        assertEquals("just a test", material.getUrl());
    }

    @Test
    public void updateDescription() throws SQLException {
        int id  = findFirst().getId();
        dao.updateDescription("just a test", id);
        Material material = dao.select(id);
        assertEquals("just a test", material.getDiscription());
    }
}