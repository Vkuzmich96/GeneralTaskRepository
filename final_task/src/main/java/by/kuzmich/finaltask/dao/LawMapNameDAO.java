package by.kuzmich.finaltask.dao;

import by.kuzmich.finaltask.bean.LawMapName;

import java.sql.SQLException;
import java.util.List;

public interface LawMapNameDAO extends DAO<LawMapName> {
    void insert (LawMapName lawMapName) throws SQLException;
    List<LawMapName> selectAll() throws SQLException;
    LawMapName select(int id) throws SQLException;
    void delete (int id) throws SQLException;
    void updateName (String value, int id) throws SQLException;
}