package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.bean.Material;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MaterialDAOMySql implements DAO <Material, Material> {
    private static Logger logger = Logger.getLogger(ConnectionPool.class);
    private Connection connection;

    public MaterialDAOMySql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert (Material material) throws SQLException {
        int id = 0;
        try {
            String sql = "INSERT INTO `lawmapsdb`.`materials` VALUES (null, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, material.getUrl());
            statement.setString(2, material.getDiscription());
            statement.execute();
            ResultSet set = statement.getGeneratedKeys();
            id = set.getInt("id");
        } catch (SQLException e){
            logger.error("its impossible to insert data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
        return id;
    }

    @Override
    public List<Material> selectAll() throws SQLException {
        List<Material> materials = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.materials";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            materials = buildList(resultSet);
        } catch (SQLException e){
            logger.error("its impossible to select data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
        return materials;
    }

    @Override
    public Material select(String id) throws SQLException{
        Material material = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.materials WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.valueOf(id));
            ResultSet set = statement.executeQuery();
            set.next();
            material = build(set);
        } catch (SQLException e){
            logger.error("its impossible to select data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
        return material;
    }

    @Override
    public void delete (int id) throws SQLException {
        try {
            String sql = "DELETE FROM `lawmapsdb`.`materials` WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e){
            logger.error("its impossible to delete data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
    }

    public void update (Material material) throws SQLException {
        try {
            String sql = "UPDATE `lawmapsdb`.`materials` SET `url` = ?, `discription` = ? WHERE `id` = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, material);
            statement.setInt(3, material.getId());
            statement.execute();
        } catch (SQLException e){
            logger.error("its impossible to update data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
    }

    @Override
    public void finalize() throws SQLException {
        connection.close();
    }

    private void prepareStatement(PreparedStatement statement, Material material) throws SQLException {
        statement.setString(1, material.getUrl());
        statement.setString(2, material.getDiscription());
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
