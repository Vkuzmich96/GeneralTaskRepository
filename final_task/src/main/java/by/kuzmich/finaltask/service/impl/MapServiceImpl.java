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
import java.util.*;

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

    public Graph get (String number) {
        List<GraphEdge> edgeList = null;
        Graph rootGraph = null;
        try {
            edgeList = graphEdgeDAO.select(number);
            GraphEdge rootEdge = edgeList.get(0);
            if (rootEdge.getParent().getId() != 0) {
                logger.error("data structure is abnormal");
            }
            rootGraph = buildRootNode(edgeList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buildNodes(edgeList, rootGraph);
    }

    private Graph buildRootNode(List<GraphEdge> edgeList) {
        return new Graph(edgeList.get(0).getChild(), null );
    }

    private Graph buildNodes(List<GraphEdge> edgeList, Graph rootGraph){
        Set<Graph> actionSet = new LinkedHashSet <>();
        for (int i = 1; i < edgeList.size(); i++) {
            GraphEdge edge = edgeList.get(i);
            if (rootGraph.getNode().getId() == edge.getParent().getId()) {
                Graph node = new Graph(edge.getChild(), null);
                actionSet.add(node);
                buildNodes(edgeList,node);
            }
        }
        rootGraph.setActionSet(actionSet);
        return rootGraph;
    }
}
