package by.kuzmich.finaltask.DAO;

import by.kuzmich.finaltask.bean.Material;

import java.sql.SQLException;
import java.util.List;

public interface MaterialDAO {
    void insert (Material material) throws SQLException;
    List<Material> selectAll() throws SQLException;
}
