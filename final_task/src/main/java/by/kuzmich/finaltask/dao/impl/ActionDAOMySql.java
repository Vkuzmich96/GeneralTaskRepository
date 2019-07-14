package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.ActionDAO;
import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionDAOMySql implements ActionDAO {
    private static Logger logger = Logger.getLogger(ConnectionPool.class);
    private Connection connection;

    public ActionDAOMySql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert (Action action) {
        try {
            String sql = "INSERT INTO `lawmapsdb`.`action` VALUES (null, ?, null)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, action.getInstructions());
            statement.execute();
        } catch (SQLException e){
            logger.error("its impossible to insert data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
    }

    @Override
    public List<Action> selectAll() throws SQLException {
        String sql = "SELECT * FROM lawmapsdb.action";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        return buildList(resultSet);
    }

    @Override
    public Action select(int id) throws SQLException{
        String sql = "SELECT * FROM lawmapsdb.action WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        set.next();
        return build(set);
    }

    @Override
    public void delete (int id) throws SQLException {
        String sql = "DELETE FROM `lawmapsdb`.`action` WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
    }

    @Override
    public void updateInstructions (String value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`action` SET `instructions` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, value);
        statement.setInt(2, id);
        statement.execute();
    }

    @Override
    public void updateUserId (int value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`action` SET `user_id` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, value);
        statement.setInt(2, id);
        statement.execute();
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
