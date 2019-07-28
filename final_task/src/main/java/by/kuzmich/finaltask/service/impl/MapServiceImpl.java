package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.*;
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
    private DAO<LawMapName, LawMapName> nameDAO;

    public MapServiceImpl(Connection connection, DAO<Material, Material> materialDAO, DAO<Action, Action> actionDAO, DAO<GraphEdge, List<GraphEdge>> graphEdgeDAO, DAO<LawMapName, LawMapName> nameDAO) {
        this.connection = connection;
        this.materialDAO = materialDAO;
        this.actionDAO = actionDAO;
        this.graphEdgeDAO = graphEdgeDAO;
        this.nameDAO = nameDAO;
    }

    public Graph get (String number) {
        List<GraphEdge> edgeList = null;
        Graph rootGraph = null;
        try {
            edgeList = graphEdgeDAO.select(number);
            if(edgeList.isEmpty()){
                String name = nameDAO.select(number).getName();
                return new Graph(name);
            }
            GraphEdge rootEdge = edgeList.get(0);
            if (rootEdge.getParent().getId() != 0) {
                logger.error("data structure is abnormal");
            }
            rootGraph = buildRootNode(edgeList, number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buildNodes(edgeList, rootGraph);
    }

    private Action buildAction(int key) {
        Action action = null;
        try {
            action = actionDAO.select(String.valueOf(key));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return action;
    }

    private Graph buildRootNode(List<GraphEdge> edgeList, String key) throws SQLException {
        Action action = buildAction(edgeList.get(0).getChild().getId());
        Graph graph = new Graph(action, null );
        LawMapName name = nameDAO.select(key);
        graph.setName(name.getName());
        return graph;
    }

    private Graph buildNodes(List<GraphEdge> edgeList, Graph rootGraph) {
        Set<Graph> actionSet = new LinkedHashSet<>();
        for (int i = 1; i < edgeList.size(); i++) {
            GraphEdge edge = edgeList.get(i);
            if (rootGraph.getNode().getId() == edge.getParent().getId()) {
                Action action = buildAction(edge.getChild().getId());
                Graph node = new Graph(action, null);
                actionSet.add(node);
                buildNodes(edgeList,node);
            }
        }
        rootGraph.setActionSet(actionSet);
        return rootGraph;
    }

    public int addEdge(GraphEdge edge) throws SQLException {
        return graphEdgeDAO.insert(edge);
    }
}
