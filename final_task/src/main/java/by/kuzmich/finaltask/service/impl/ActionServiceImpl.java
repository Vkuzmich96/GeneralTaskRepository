package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.ActionMaterialLink;
import by.kuzmich.finaltask.bean.Material;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.service.ActionService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionServiceImpl implements ActionService {
    private static Logger logger = Logger.getLogger(ActionServiceImpl.class);

    private Connection connection;
    private DAO<Action, Action> actionDAO;
    private DAO<Material, Material> materialDAO;
    private DAO<ActionMaterialLink, List<ActionMaterialLink>> linkListDAO;

    public ActionServiceImpl(Connection connection, DAO<Action, Action> actionDAO, DAO<Material, Material> materialDAO, DAO<ActionMaterialLink, List<ActionMaterialLink>> linkListDAO) {
        this.connection = connection;
        this.actionDAO = actionDAO;
        this.materialDAO = materialDAO;
        this.linkListDAO = linkListDAO;
    }

    @Override
    public int add (Action action) throws SQLException {
        int actionId = actionDAO.insert(action);
        List<Material> materials = action.getMaterials();
        for (Material material : materials) {
            int materialId = materialDAO.insert(material);
            linkListDAO.insert(new ActionMaterialLink(actionId, materialId));
        }
        return actionId;
    }

    @Override
    public Action get(String key) {
        Action action = null;
        try {
            action = actionDAO.select(key);
            action.setMaterials(buildMaterials (key));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return action;
    }

    private List<Material> buildMaterials (String key) throws SQLException {
        List<ActionMaterialLink> links = linkListDAO.select(key);
        List<Material> materials = new ArrayList<>();
        for (ActionMaterialLink link: links){
            int id = link.getMaterialId();
            materials.add(materialDAO.select(String.valueOf(id)));
        }
        return materials;
    }

    public int addMaterial(Material material) throws SQLException {
        return materialDAO.insert(material);
    }
}
