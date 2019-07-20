package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.service.impl.MapServiceImpl;

import java.sql.Connection;

public class MapServiceFactory {
    private final static MapServiceFactory factory = new MapServiceFactory();
    private MapServiceFactory(){}
    public static MapServiceFactory getInstance(){
        return factory;
    }
    public MapService get (){
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            return new MapServiceImpl(
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
