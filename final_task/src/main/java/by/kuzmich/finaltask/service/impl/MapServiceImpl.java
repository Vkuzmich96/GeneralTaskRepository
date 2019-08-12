package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.*;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.exception.ExceptionMessageList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.MapService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.*;

public class MapServiceImpl implements MapService {
    private static Logger logger = Logger.getLogger(MapServiceImpl.class);

    private DAO<Action, Action> actionDAO;
    private DAO<GraphEdge, List<GraphEdge>> graphEdgeDAO;
    private DAO<LawMapName, LawMapName> nameDAO;

    public MapServiceImpl( DAO<Action, Action> actionDAO, DAO<GraphEdge, List<GraphEdge>> graphEdgeDAO, DAO<LawMapName, LawMapName> nameDAO) {
        this.actionDAO = actionDAO;
        this.graphEdgeDAO = graphEdgeDAO;
        this.nameDAO = nameDAO;
    }

    public Graph get (String number) throws ServiceException {
        try {
            List<GraphEdge> edgeList = graphEdgeDAO.select(number);
            if(edgeList.isEmpty()){
                String name = nameDAO.select(number).getName();
                return new Graph(name);
            }
            GraphEdge rootEdge = edgeList.get(0);
            if (rootEdge.getParent().getId() != 0) {
                logger.error("data structure is abnormal");
            }
            Graph rootGraph = buildRootNode(edgeList, number);
            return buildNodes(edgeList, rootGraph);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    private Action buildAction(int key) throws DAOException {
        return actionDAO.select(String.valueOf(key));
    }

    private Graph buildRootNode(List<GraphEdge> edgeList, String key) throws DAOException {
        Action action = buildAction(edgeList.get(0).getChild().getId());
        Graph graph = new Graph(action, null );
        LawMapName name = nameDAO.select(key);
        graph.setName(name.getName());
        return graph;
    }

    private Graph buildNodes(List<GraphEdge> edgeList, Graph rootGraph) throws DAOException {
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

    public int addEdge(GraphEdge edge) throws ServiceException {
        try {
            return graphEdgeDAO.insert(edge);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    public List<GraphEdge> getAll(String key) throws ServiceException {
        try {
            return graphEdgeDAO.selectAll();
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }
}
