package by.kuzmich.finaltask.dao;

import by.kuzmich.finaltask.dao.impl.*;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.Connection;


final public class DAOFactory {
    private static final DAOFactory factory = new DAOFactory();

    public static DAOFactory getInstance(){
        return factory;
    }

    private static Logger logger = Logger.getLogger(ConnectionPool.class);

    private DAOFactory(){}

    public DAO get (DAOKinds kind, Connection connection) throws DAOException {
            switch (kind) {
                case UserDAOMySql:
                    return  new UserDAOMySql(connection);
                case ActionDAOMySql:
                    return new ActionDAOMySql(connection);
                case MaterialDAOMySql:
                    return new MaterialDAOMySql(connection);
                case LawMapNameDAOMySql:
                    return new LawMapNameDAOMySql(connection);
                case ActionMaterialLinkDAOMySql:
                     return new ActionMaterialLinkDAOMySql (connection);
                case GraphEdgeDAOMySql:
                    return new GraphEdgeDAOMySql (connection);
                default:
                    throw new DAOException("this DAO does not exist - " + kind);
            }
    }
}
