package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.GraphEdge;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOMySQL;
import org.apache.log4j.Logger;
import java.sql.Types;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GraphEdgeDAOMySql extends DAOMySQL<GraphEdge, List<GraphEdge>> {
    private final int ID_INDEX = 1;
    private final int PARENT_ID_INDEX = 2;
    private final int CHILD_ID_INDEX = 3;
    private final int ID_INDEX_FOR_UPDATE = 4;
    private final String LAW_MAP_NAME_ID = "law_map_name_id";
    private final String PARENT = "parent";
    private final String CHILD = "child";

    public GraphEdgeDAOMySql(Connection connection) {
        super(connection,
             "INSERT INTO `lawmapsdb`.`action_graphs` VALUES (?, ?, ?)",
             "SELECT * FROM action_graphs.action",
             "SELECT * FROM lawmapsdb.action_graphs WHERE law_map_name_id = ?",
             "DELETE FROM `lawmapsdb`.`action_graphs` WHERE law_map_name_id = ?",
             "UPDATE `lawmapsdb`.`action_graphs` SET `law_map_name_id` = ?, `parent` = ?, `child` = ? WHERE `id` = ?"
        );
    }

    private void prepareStatement(PreparedStatement statement, GraphEdge edge) throws SQLException {
        statement.setInt(ID_INDEX, edge.getId());
        statement.setInt(CHILD_ID_INDEX, edge.getChild().getId());
    }

    @Override
    protected void prepareStatementInsert(PreparedStatement statement, GraphEdge edge) throws SQLException {
        prepareStatement(statement, edge);
        if(edge.getParent() == null){
            statement.setNull(PARENT_ID_INDEX, Types.INTEGER);
        }else {
            statement.setInt(PARENT_ID_INDEX, edge.getParent().getId());
        }
    }

    @Override
    protected void prepareStatementUpdate(PreparedStatement statement, GraphEdge edge) throws SQLException {
        prepareStatement(statement, edge);
        statement.setInt(CHILD_ID_INDEX, edge.getParent().getId());
        statement.setInt(ID_INDEX_FOR_UPDATE, edge.getId());
    }

    protected GraphEdge build(ResultSet set) throws SQLException {
        int id = set.getInt(LAW_MAP_NAME_ID);
        int parentId = set.getInt(PARENT);
        int childId = set.getInt(CHILD);
        return new GraphEdge(id, new Action(parentId), new Action(childId));
    }

    @Override
    protected List<GraphEdge> buildToSelect(ResultSet set) throws SQLException {
        return super.buildList(set);
    }
}
