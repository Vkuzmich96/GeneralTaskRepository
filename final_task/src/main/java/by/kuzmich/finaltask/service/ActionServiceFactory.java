package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.service.impl.ActionServiceImpl;

import java.sql.Connection;

final public class ActionServiceFactory {
    private final static ActionServiceFactory factory = new ActionServiceFactory();
    private ActionServiceFactory(){}
    public static ActionServiceFactory getInstance(){
        return factory;
    }
    public ActionService get (){
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            return new ActionServiceImpl(
                    connection,
                    DAOFactory.getInstance().get(DAOKinds.ActionDAOMySql, connection),
                    DAOFactory.getInstance().get(DAOKinds.MaterialDAOMySql, connection)
                    );
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
