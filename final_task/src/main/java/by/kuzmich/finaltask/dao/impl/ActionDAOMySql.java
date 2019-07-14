package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionDAOMySql implements DAO<Action, Action> {
    private static Logger logger = Logger.getLogger(ConnectionPool.class);
    private Connection connection;

    public ActionDAOMySql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert (Action action) {
        int id = 0;
        try {
            String sql = "INSERT INTO `lawmapsdb`.`action` VALUES (null, ?, null)";
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, action);
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
    public List<Action> selectAll(){
        List<Action> list = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.action";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            list = buildList(resultSet);
        } catch (SQLException e){
            logger.error("its impossible to select data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
        return list;
    }

    @Override
    public Action select(int id) {
        Action action = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.action WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            set.next();
            action = build(set);
        } catch (SQLException e){
            logger.error("its impossible to select data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
        return action;
    }

    @Override
    public void delete (int id) {
        try {
            String sql = "DELETE FROM `lawmapsdb`.`action` WHERE id = ?";
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

    public void update (Action action){
        try {
            String sql = "UPDATE `lawmapsdb`.`action` SET `instructions` = ?, `user_id` = ? WHERE `id` = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, action);
            statement.setInt(2, action.getUser().getId());
            statement.setInt(3, action.getId());
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

    private void prepareStatement(PreparedStatement statement, Action action) throws SQLException {
        statement.setString(1, action.getInstructions());
    }

    private List<Action> buildList (ResultSet set) throws SQLException {
        List<Action> materials = new ArrayList<>();
        while (set.next()){
            Action action = build(set);
            materials.add(action);
        }
        return materials;
    }

    private Action build(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String instructions = set.getString("instructions");
        return new Action(id,instructions,null,null);
    }
}
