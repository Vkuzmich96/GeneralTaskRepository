package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.Material;
import by.kuzmich.finaltask.exception.ServiceException;

import java.sql.SQLException;

public interface ActionService {
    Action get(String key) throws ServiceException;
    int add (Action action) throws ServiceException;
    int addMaterial(Material material) throws ServiceException;
}
