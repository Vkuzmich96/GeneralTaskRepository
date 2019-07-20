package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.service.impl.GraphServiceImpl;

import java.sql.Connection;

public class GraphServiceFactory {
    private final static GraphServiceFactory factory = new GraphServiceFactory();
    private GraphServiceFactory (){}
    public static GraphServiceFactory getInstance(){
        return factory;
    }
    public  GraphService get (){
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            return new GraphServiceImpl(
                    connection,
                    DAOFactory.getInstance().get(DAOKinds.MaterialDAOMySql, connection),
                    DAOFactory.getInstance().get(DAOKinds.ActionDAOMySql, connection),
                    DAOFactory.getInstance().get(DAOKinds.GraphEdgeDAOMySql, connection)
                    );
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
