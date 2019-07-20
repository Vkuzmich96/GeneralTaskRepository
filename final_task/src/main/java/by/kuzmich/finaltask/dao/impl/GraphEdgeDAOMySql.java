package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.GraphEdge;
import by.kuzmich.finaltask.dao.DAO;
import org.apache.log4j.Logger;
import java.sql.Types;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GraphEdgeDAOMySql implements DAO<GraphEdge, List<GraphEdge>> {

    private static Logger logger = Logger.getLogger(GraphEdgeDAOMySql.class);
    private Connection connection;

    public GraphEdgeDAOMySql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert (GraphEdge edge) {
        int id = 0;
        try {
            String sql = "INSERT INTO `lawmapsdb`.`action_graphs` VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            if(edge.getParent() == null){
                statement.setNull(2, Types.INTEGER);
            }else {
                statement.setInt(2, edge.getParent().getId());
            }
            prepareStatement(statement, edge);
            statement.executeUpdate();
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
    public List<GraphEdge> selectAll(){
        List<GraphEdge> list = null;
        try {
            String sql = "SELECT * FROM action_graphs.action";
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
    public List<GraphEdge> select(String id) {
        List<GraphEdge> list = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.action_graphs WHERE law_map_name_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
            ResultSet set = statement.executeQuery();
            list = buildList(set);
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
    public void delete (int id) {
        try {
            String sql = "DELETE FROM `lawmapsdb`.`action_graphs` WHERE law_map_name_id = ?";
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

    public void update (GraphEdge edge){
        try {
            String sql = "UPDATE `lawmapsdb`.`action_graphs` SET `law_map_name_id` = ?, `parent` = ?, `child` = ? WHERE `id` = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(2, edge.getParent().getId());
            prepareStatement(statement, edge);
            statement.executeUpdate();
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

    private void prepareStatement(PreparedStatement statement, GraphEdge edge) throws SQLException {
        statement.setInt(1, edge.getId());
        statement.setInt(3, edge.getChild().getId());
    }

    private List<GraphEdge> buildList (ResultSet set) throws SQLException {
        List<GraphEdge> materials = new ArrayList<>();
        while (set.next()){
            GraphEdge action = build(set);
            materials.add(action);
        }
        return materials;
    }

    private GraphEdge build(ResultSet set) throws SQLException {
        int id = set.getInt("law_map_name_id");
        int parentId = set.getInt("parent");
        int childId = set.getInt("child");
        return new GraphEdge(id, new Action(parentId), new Action(childId));
    }
}
