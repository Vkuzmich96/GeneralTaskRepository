package by.kuzmich.finaltask.DAO.impl;

import by.kuzmich.finaltask.DAO.utils.MySQLConnection;
import by.kuzmich.finaltask.bean.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionDAOMySql {
    private Connection connection = MySQLConnection.getConnection();

    public List<Material> selectAll() throws SQLException {
        String sql = "SELECT * FROM lawmapsdb.action";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        return buildMaterialList(resultSet);
    }

    private List<Material> buildMaterialList (ResultSet set) throws SQLException {
        List<Material> materials = new ArrayList<>();
        while (set.next()){
            Material material = buildMaterial(set);
            materials.add(material);
        }
        return materials;
    }

    private Material buildMaterial(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String url = set.getString("url");
        String description = set.getString("discription");
        return new Material(id,url,description);
    }
}
