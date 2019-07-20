package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.Graph;
import by.kuzmich.finaltask.bean.GraphEdge;
import by.kuzmich.finaltask.bean.Material;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.service.MapService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MapServiceImpl implements MapService {
    private static Logger logger = Logger.getLogger(MapServiceImpl.class);

    private Connection connection;
    private DAO<Material, Material> materialDAO;
    private DAO<Action, Action> actionDAO;
    private DAO<GraphEdge, List<GraphEdge>> graphEdgeDAO;

    public MapServiceImpl(Connection connection, DAO<Material, Material> materialDAO, DAO<Action, Action> actionDAO, DAO<GraphEdge, List<GraphEdge>> graphEdgeDAO) {
        this.connection = connection;
        this.materialDAO = materialDAO;
        this.actionDAO = actionDAO;
        this.graphEdgeDAO = graphEdgeDAO;
    }

    public Graph get (String number){
        List<GraphEdge> edgeList = null;
        try {
            edgeList = graphEdgeDAO.select(number);
            if(edgeList.get(0).getParent().getId()!=0){
                logger.error("data structure is abnormal");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buildGraph(edgeList);
    }

    private Graph buildGraph(List<GraphEdge> edgeList){
        Graph graph = new Graph(null, null);
        return graph;
    }


}
