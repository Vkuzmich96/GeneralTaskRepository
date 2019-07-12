package by.kuzmich.finaltask.DAO;

import by.kuzmich.finaltask.DAO.impl.MaterialDAOMySql;
import by.kuzmich.finaltask.bean.Material;
import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.SQLException;


public class MaterialDAOTest {
    private MaterialDAOMySql dao = new MaterialDAOMySql();
    private Material material = new Material(0, "jdbc.properties", "lorem ipsum");

    @Test
    public void insert() throws SQLException {
        dao.insert(material);
    }

    @Test
    public void selectAll() throws SQLException{
        assertFalse(dao.selectAll().isEmpty());
    }
}