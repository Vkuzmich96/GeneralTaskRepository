package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.ActionMaterialLink;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOMySQL;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActionMaterialLinkDAOMySql extends DAOMySQL<ActionMaterialLink, List<ActionMaterialLink>> {
    private String ID = "id";
    private String ACTION_ID = "action_id";
    private String MATERIAL_ID = "materia_id";

    public ActionMaterialLinkDAOMySql(Connection connection) {
        super(connection,
             "INSERT INTO `lawmapsdb`.`material_links_list` VALUES (null, ?, ?)",
             "SELECT * FROM lawmapsdb.material_links_list",
             "SELECT * FROM lawmapsdb.material_links_list WHERE action_id = ?",
             "DELETE FROM `lawmapsdb`.`material_links_list` WHERE id = ?",
             "UPDATE `lawmapsdb`.`material_links_list` SET `action_id` = ?, `materia_id` = ?  WHERE `id` = ?"
        );
    }

    @Override
    protected void prepareStatementInsert(PreparedStatement statement, ActionMaterialLink link) throws SQLException {
        statement.setInt(1, link.getActionId());
        statement.setInt(2, link.getMaterialId());
    }

    @Override
    protected void prepareStatementUpdate(PreparedStatement statement, ActionMaterialLink link) throws SQLException {
        prepareStatementInsert(statement, link);
        statement.setInt(3, link.getId() );
    }



    protected ActionMaterialLink build(ResultSet set) throws SQLException {
        int id = set.getInt(ID);
        int actionId = set.getInt(ACTION_ID);
        int materialId = set.getInt(MATERIAL_ID);
        return new ActionMaterialLink(id, actionId, materialId);
    }

    @Override
    protected List<ActionMaterialLink> prepareSelectResult(ResultSet set) throws SQLException {
        return super.buildList(set);
    }
}
