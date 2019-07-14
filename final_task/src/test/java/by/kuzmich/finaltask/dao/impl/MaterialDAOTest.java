package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.DAOMySqlFactory;
import by.kuzmich.finaltask.bean.Material;
import static org.junit.Assert.*;


import by.kuzmich.finaltask.exception.DAOException;
import org.junit.Test;

import java.sql.SQLException;


public class MaterialDAOTest {
    private DAO<Material, Material> dao;

    {
        try {
            dao = (MaterialDAOMySql) DAOMySqlFactory.getInstance().get(DAOKinds.MaterialDAOMySql);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private Material material = new Material(0, "jdbc.properties", "lorem ipsum");
    private Material materialUpdate = new Material(0, "just a test", "just a test");


    private Material findFirst() throws SQLException {
        return dao.selectAll().get(0);
    }

    @Test
    public void insert() throws SQLException {
        int id = dao.insert(material);
        dao.select(id);
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
    public void update() throws SQLException {
        int id  = findFirst().getId();
        materialUpdate.setId(id);
        dao.update(materialUpdate);
    }

}