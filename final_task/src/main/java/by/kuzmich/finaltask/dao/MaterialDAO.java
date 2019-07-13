package by.kuzmich.finaltask.dao;

import by.kuzmich.finaltask.bean.Material;

import java.sql.SQLException;
import java.util.List;

public interface MaterialDAO {
    void insert (Material material) throws SQLException;
    List<Material> selectAll() throws SQLException;
    void delete (int id) throws SQLException;
    Material select(int id) throws SQLException;
    void updateUrl (String value, int id) throws SQLException;
    void updateDescription (String value, int id) throws SQLException;
}
