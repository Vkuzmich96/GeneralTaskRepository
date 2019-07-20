package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.GraphEdge;
import by.kuzmich.finaltask.bean.Material;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.service.GraphService;

import java.sql.Connection;
import java.util.List;

public class GraphServiceImpl implements GraphService {
    private Connection connection;
    private DAO<Material, Material> materialDAO;
    private DAO<Action, Action> actionDAO;
    private DAO<GraphEdge, List<GraphEdge>> graphEdgeDAO;

    public GraphServiceImpl(Connection connection, DAO<Material, Material> materialDAO, DAO<Action, Action> actionDAO, DAO<GraphEdge, List<GraphEdge>> graphEdgeDAO) {
        this.connection = connection;
        this.materialDAO = materialDAO;
        this.actionDAO = actionDAO;
        this.graphEdgeDAO = graphEdgeDAO;
    }


}
