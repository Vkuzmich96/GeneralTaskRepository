package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.Material;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.service.ActionService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class ActionServiceImpl implements ActionService {
    private static Logger logger = Logger.getLogger(ActionServiceImpl.class);

    private Connection connection;
    private DAO<Action, Action> actionDAO;
    private DAO<Material, Material> materialDAO;

    public ActionServiceImpl(Connection connection, DAO<Action, Action> actionDAO, DAO<Material, Material> materialDAO) {
        this.connection = connection;
        this.actionDAO = actionDAO;
        this.materialDAO = materialDAO;
    }

    @Override
    public Action get(String key) {
        Action action = null;
        try {
            action = actionDAO.select(key);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return action;
    }
}
