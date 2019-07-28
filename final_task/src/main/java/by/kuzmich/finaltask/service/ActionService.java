package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.bean.Action;

import java.sql.SQLException;

public interface ActionService {
    Action get(String key);
    int add (Action action) throws SQLException;
}
