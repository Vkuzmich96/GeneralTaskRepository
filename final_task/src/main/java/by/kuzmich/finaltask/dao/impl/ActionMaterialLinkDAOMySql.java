package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.ActionMaterialLink;
import by.kuzmich.finaltask.dao.DAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionMaterialLinkDAOMySql implements DAO<ActionMaterialLink, List<ActionMaterialLink>> {
    private static Logger logger = Logger.getLogger(ActionMaterialLinkDAOMySql.class);
    private Connection connection;

    public ActionMaterialLinkDAOMySql(Connection connection) {
        this.connection = connection;
    }

    public int insert (ActionMaterialLink link) {
        int id = 0;
        try {
            String sql = "INSERT INTO `lawmapsdb`.`material_links_list` VALUES (null, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, link.getActionId());
            statement.setInt(2, link.getMaterialId());
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

    public List<ActionMaterialLink> selectAll() {
        List<ActionMaterialLink> links = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.material_links_list";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            links = buildList(resultSet);
        } catch (SQLException e){
            logger.error("its impossible to select data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
        return links;
    }

    public List<ActionMaterialLink> select(String id) {
        List<ActionMaterialLink> links = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.material_links_list WHERE action_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            links = buildList(resultSet);
        } catch (SQLException e){
            logger.error("its impossible to select data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
        return links;
    }

    public void delete (int id) {
        try {
            String sql = "DELETE FROM `lawmapsdb`.`material_links_list` WHERE id = ?";
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

    public void update (ActionMaterialLink link){
        try {
            String sql = "UPDATE `lawmapsdb`.`material_links_list` SET `action_id` = ?, `materia_id` = ?  WHERE `id` = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, link);
            statement.setInt(3, link.getId() );
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

    private void prepareStatement(PreparedStatement statement, ActionMaterialLink link) throws SQLException {
        statement.setInt(1, link.getActionId());
        statement.setInt(2, link.getMaterialId());
    }

    private List<ActionMaterialLink> buildList (ResultSet set) throws SQLException {
        List<ActionMaterialLink> materials = new ArrayList<>();
        while (set.next()){
            ActionMaterialLink link = build(set);
            materials.add(link);
        }
        return materials;
    }

    private ActionMaterialLink build(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        int action_id = set.getInt("action_id");
        int materia_id = set.getInt("materia_id");
        return new ActionMaterialLink(id, action_id, materia_id);
    }
}
