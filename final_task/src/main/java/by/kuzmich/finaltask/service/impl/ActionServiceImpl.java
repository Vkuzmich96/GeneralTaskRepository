package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.ActionMaterialLink;
import by.kuzmich.finaltask.bean.Material;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.exception.ExceptionMessageList;
import by.kuzmich.finaltask.exception.ServiceException;
import by.kuzmich.finaltask.service.ActionService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ActionServiceImpl implements ActionService {

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
    public int add (Action action) throws ServiceException {
        try {
            int actionId = actionDAO.insert(action);
            List<Material> materials = action.getMaterials();
            for (Material material : materials) {
                int materialId = materialDAO.insert(material);
                linkListDAO.insert(new ActionMaterialLink(actionId, materialId));
            }
            return actionId;
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    @Override
    public Action get(String key) throws ServiceException {
        try {
            Action action = actionDAO.select(key);
            action.setMaterials(buildMaterials(key));
            return action;
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    private List<Material> buildMaterials (String key) throws DAOException {
        List<ActionMaterialLink> links = linkListDAO.select(key);
        List<Material> materials = new ArrayList<>();
        for (ActionMaterialLink link: links){
            int id = link.getMaterialId();
            materials.add(materialDAO.select(String.valueOf(id)));
        }
        return materials;
    }

    public int addMaterial(Material material) throws ServiceException {
        try {
            return materialDAO.insert(material);
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }

    public void update(Action action) throws ServiceException {
        try {
            actionDAO.update(action);
        for (Material material : action.getMaterials()){
            materialDAO.update(material);
        }
        } catch (DAOException e) {
            throw new ServiceException(ExceptionMessageList.UNABLE_TO_GET_DATA_ACCESS, e);
        }
    }
}
