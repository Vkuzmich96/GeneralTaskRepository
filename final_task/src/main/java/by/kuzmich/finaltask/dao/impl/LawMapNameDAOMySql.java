package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.bean.LawMapName;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LawMapNameDAOMySql implements DAO<LawMapName, LawMapName> {
    private static Logger logger = Logger.getLogger(ConnectionPool.class);

    private Connection connection;

    public LawMapNameDAOMySql(Connection connection) {
        this.connection = connection;
    }

    public int insert (LawMapName lawMapName) throws SQLException {
        int id = 0;
        try {
            String sql = "INSERT INTO `lawmapsdb`.`law_map_name` VALUES (null, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, lawMapName);
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

    public List<LawMapName> selectAll() throws SQLException {
        List<LawMapName> names = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.law_map_name";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            names = buildList(resultSet);
        } catch (SQLException e){
            logger.error("its impossible to select data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
        return names;
    }

    public LawMapName select(String  id) throws SQLException{
        LawMapName name = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.law_map_name WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.valueOf(id));
            ResultSet set = statement.executeQuery();
            set.next();
            name = build(set);
        } catch (SQLException e){
            logger.error("its impossible to select data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
        return name;
    }

    public void delete (int id) throws SQLException {
        try {
            String sql = "DELETE FROM `lawmapsdb`.`law_map_name` WHERE id = ?";
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

    public void update (LawMapName name) throws SQLException {
        try {
            String sql = "UPDATE `lawmapsdb`.`law_map_name` SET `name` = ? WHERE `id` = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, name);
            statement.setInt(2, name.getId());
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

    @Override
    public void finalize() throws SQLException {
        connection.close();
    }

    private void prepareStatement(PreparedStatement statement, LawMapName name) throws SQLException {
        statement.setString(1, name.getName());
    }

    private List<LawMapName> buildList (ResultSet set) throws SQLException {
        List<LawMapName> materials = new ArrayList<>();
        while (set.next()){
            LawMapName lawMapName = build(set);
            materials.add(lawMapName);
        }
        return materials;
    }

    private LawMapName build(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String name = set.getString("name");
        return new LawMapName(id, name);
    }
}
