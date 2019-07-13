package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.ActionMaterialLink;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionMateriallLinkDAOMySql {
    private Connection connection;

    public ActionMateriallLinkDAOMySql(Connection connection) {
        this.connection = connection;
    }

    public void insert (ActionMaterialLink link) throws SQLException {
        String sql = "INSERT INTO `lawmapsdb`.`material_links_list` VALUES (null, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, link.getActionId());
        statement.setInt(2, link.getMaterialId());
        statement.execute();
    }

    public List<ActionMaterialLink> selectAll() throws SQLException {
        String sql = "SELECT * FROM lawmapsdb.material_links_list";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        return buildList(resultSet);
    }

    public List<ActionMaterialLink> select(int id) throws SQLException {
        String sql = "SELECT * FROM lawmapsdb.material_links_list WHERE action_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        return buildList(resultSet);
    }

    public void delete (int id) throws SQLException {
        String sql = "DELETE FROM `lawmapsdb`.`material_links_list` WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
    }

    public void updateAction (int value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`material_links_list` SET `action_id` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, value);
        statement.setInt(2, id);
        statement.execute();
    }

    public void updateMaterial (int value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`material_links_list` SET `materia_id` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, value);
        statement.setInt(2, id);
        statement.execute();
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
