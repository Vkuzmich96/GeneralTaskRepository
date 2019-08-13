package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.service.impl.LawMapNameServiceImpl;

final public class LawMapNameServiceFactory {
    private final static LawMapNameServiceFactory factory = new LawMapNameServiceFactory();
    private LawMapNameServiceFactory (){}
    public static LawMapNameServiceFactory getInstance(){
        return factory;
    }
    public  LawMapNameService get (){
        try {
            return new LawMapNameServiceImpl(
                    DAOFactory.getInstance().get(DAOKinds.LawMapNameDAOMySql, ConnectionPool.getInstance().getConnection()),
                    DAOFactory.getInstance().get(DAOKinds.LawMapNameSelectByNameDAOMySql, ConnectionPool.getInstance().getConnection())
            );
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
