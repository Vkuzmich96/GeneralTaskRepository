package by.kuzmich.finaltask.service.impl;

import by.kuzmich.finaltask.bean.LawMapName;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.service.LawMapNameService;

import java.sql.SQLException;
import java.util.List;

public class LawMapNameServiceImpl implements LawMapNameService {
    private DAO<LawMapName, LawMapName> dao;

    public LawMapNameServiceImpl(DAO<LawMapName, LawMapName> dao) {
        this.dao = dao;
    }

    public List<LawMapName> getAll() throws SQLException {
        return dao.selectAll();
    }

    public int add (String name) throws SQLException {
        return dao.insert(new LawMapName(0, name));
    }
}
