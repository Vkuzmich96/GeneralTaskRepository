package by.kuzmich.finaltask.dao;

import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.impl.*;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import org.apache.log4j.Logger;

final public class DAOFactory {
    private static final DAOFactory factory = new DAOFactory();

    public static DAOFactory getInstance(){
        return factory;
    }

    private static Logger logger = Logger.getLogger(ConnectionPool.class);

    private static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/lawmapsdb?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static final int DB_POOL_START_SIZE = 10;
    private static final int DB_POOL_MAX_SIZE = 1000;
    private static final int DB_POOL_CHECK_CONNECTION_TIMEOUT = 0;

    private DAOFactory(){
        try {
            ConnectionPool.getInstance().init(DB_DRIVER_CLASS, DB_URL, DB_USER, DB_PASSWORD, DB_POOL_START_SIZE, DB_POOL_MAX_SIZE, DB_POOL_CHECK_CONNECTION_TIMEOUT );
        } catch (DAOException e) {
            logger.error("it is impossible to initialize connection pool", e);
        }
    }

    public DAO get (DAOKinds kind) throws DAOException {
            switch (kind) {
                case UserDAOMySql:
                    return  new UserDAOMySql(ConnectionPool.getInstance().getConnection());
                case ActionDAOMySql:
                    return new ActionDAOMySql(ConnectionPool.getInstance().getConnection());
                case MaterialDAOMySql:
                    return new MaterialDAOMySql(ConnectionPool.getInstance().getConnection());
                case LawMapNameDAOMySql:
                    return new LawMapNameDAOMySql(ConnectionPool.getInstance().getConnection());
              case ActionMaterialLinkDAOMySql:
                  return new ActionMaterialLinkDAOMySql (ConnectionPool.getInstance().getConnection());
                default:
                    throw new DAOException("this DAO does not exist - " + kind);
            }
    }
}
