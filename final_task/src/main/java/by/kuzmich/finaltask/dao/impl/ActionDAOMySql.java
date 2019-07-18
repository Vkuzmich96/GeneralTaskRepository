package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.DAO;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActionDAOMySql implements DAO<Action, Action> {
    private static Logger logger = Logger.getLogger(ActionDAOMySql.class);
    private Connection connection;

    public ActionDAOMySql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert (Action action) {
        int id = 0;
        try {
            String sql = "INSERT INTO `lawmapsdb`.`action` VALUES (null, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepareStatement(statement, action);
            statement.execute();
            ResultSet set = statement.getGeneratedKeys();
            set.next();
            id = set.getInt(1);
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
    public Action select(String id) {
        Action action = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.action WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.valueOf(id));
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
            String sql = "UPDATE `lawmapsdb`.`action` SET `name` = ? `instructions` = ?, `user_id` = ? WHERE `id` = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, action);
            statement.setInt(4, action.getId());
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

    private void prepareStatement(PreparedStatement statement, Action action) throws SQLException {
        statement.setString(1, action.getName());
        statement.setString(2, action.getInstructions());
        statement.setInt(3, action.getUser().getId());
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
        String name = set.getString("name");
        String instructions = set.getString("instructions");
        int userId = set.getInt("user_id");
        return new Action(id, name,instructions,null, new User(userId));
    }
}
