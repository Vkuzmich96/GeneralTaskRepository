package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.GraphEdge;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class GraphEdgeDAOMySqlTest {

    private DAO<GraphEdge, List<GraphEdge>> dao;

    {
        try {
            dao = (GraphEdgeDAOMySql) DAOFactory.getInstance().get(DAOKinds.GraphEdgeDAOMySql, ConnectionPool.getInstance().getConnection());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    private GraphEdge findFirst() throws DAOException {
        return dao.selectAll().get(0);
    }

    private GraphEdge edge = new GraphEdge(1, new Action(1), new Action(1));

    @Test
    public void insert() throws DAOException {
        dao.insert(edge);
    }

    @Test
    public void selectAll() throws DAOException {
        assertFalse(dao.selectAll().isEmpty());
    }

    @Test
    public void select() throws DAOException {
        assertFalse(dao.select(String.valueOf(1)).isEmpty());
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }
}