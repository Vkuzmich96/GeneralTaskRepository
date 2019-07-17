package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.dao.DAOFactory;
import by.kuzmich.finaltask.dao.DAOKinds;
import by.kuzmich.finaltask.exception.DAOException;

final public class UserServiceFactory {
    private final static UserServiceFactory factory = new UserServiceFactory();
    private UserServiceFactory (){}
    public static UserServiceFactory getInstance(){
        return factory;
    }
    public  UserService get (){
        try {
            return new UserServiceImpl(
                    DAOFactory.getInstance().get(DAOKinds.UserDAOMySql)
            );
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
