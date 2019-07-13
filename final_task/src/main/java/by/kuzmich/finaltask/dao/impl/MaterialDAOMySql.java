package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.MaterialDAO;
import by.kuzmich.finaltask.bean.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MaterialDAOMySql implements MaterialDAO {
    private Connection connection;

    public MaterialDAOMySql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert (Material material) throws SQLException {
        String sql = "INSERT INTO `lawmapsdb`.`materials` VALUES (null, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, material.getUrl());
        statement.setString(2, material.getDiscription());
        statement.execute();
    }

    @Override
    public List<Material> selectAll() throws SQLException {
        String sql = "SELECT * FROM lawmapsdb.materials";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        return buildList(resultSet);
    }

    @Override
    public void delete (int id) throws SQLException {
        String sql = "DELETE FROM `lawmapsdb`.`materials` WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
    }

    @Override
    public Material select(int id) throws SQLException{
        String sql = "SELECT * FROM lawmapsdb.materials WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        set.next();
        return build(set);
    }

    @Override
    public void updateUrl (String value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`materials` SET `url` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, value);
        statement.setInt(2, id);
        statement.execute();
    }

    @Override
    public void updateDescription (String value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`materials` SET `discription` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, value);
        statement.setInt(2, id);
        statement.execute();
    }

    private List<Material> buildList (ResultSet set) throws SQLException {
        List<Material> materials = new ArrayList<>();
        while (set.next()){
            Material material = build(set);
            materials.add(material);
        }
        return materials;
    }

    private Material build(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String url = set.getString("url");
        String description = set.getString("discription");
        return new Material(id,url,description);
    }
}
