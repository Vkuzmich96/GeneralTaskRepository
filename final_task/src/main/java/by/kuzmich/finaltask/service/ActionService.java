package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.Material;

import java.sql.SQLException;

public interface ActionService {
    Action get(String key);
    int add (Action action) throws SQLException;
    int addMaterial(Material material) throws SQLException;
}
