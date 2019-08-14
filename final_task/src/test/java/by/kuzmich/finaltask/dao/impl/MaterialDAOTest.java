package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.bean.Material;
import static org.junit.Assert.*;


import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class MaterialDAOTest {
    private DAO<Material, Material> dao;

    {
        try {
            dao = (MaterialDAOMySql) DAOFactory.getInstance().get(DAOKinds.MaterialDAOMySql, ConnectionPool.getInstance().getConnection());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private Material material = new Material(
            0,
            "jdbc.properties",
            "lorem ipsum",
            "loren ipsum"
    );
    private Material materialUpdate = new Material(
            0,
            "just a test",
            "just a test",
            "just a test"
    );


    private Material findLast() throws DAOException {
        List<Material> list = dao.selectAll();
        return list.get(list.size() -1);
    }

    @Test
    public void insert() throws DAOException {
        int id = dao.insert(material);
        assertTrue(id != 0);
    }

    @Test
    public void selectAll() throws DAOException{
        assertFalse(dao.selectAll().isEmpty());
    }

    @Test
    public void select() throws DAOException {
        int id = findLast().getId();
        Material material = dao.select(String.valueOf(id));
        assertEquals(id, material.getId());
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
        materialUpdate.setId(id);
        dao.update(materialUpdate);
    }

}