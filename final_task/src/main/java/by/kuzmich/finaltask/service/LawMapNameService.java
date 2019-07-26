package by.kuzmich.finaltask.service;

import by.kuzmich.finaltask.bean.LawMapName;

import java.sql.SQLException;
import java.util.List;

public interface LawMapNameService {
    List<LawMapName> getAll() throws SQLException;
    int add (String name) throws SQLException;
}
