package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.LawMapNameDAO;
import by.kuzmich.finaltask.bean.LawMapName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LawMapNameDAOMySql implements LawMapNameDAO {

    private Connection connection;

    public LawMapNameDAOMySql(Connection connection) {
        this.connection = connection;
    }

    public void insert (LawMapName lawMapName) throws SQLException {
        String sql = "INSERT INTO `lawmapsdb`.`law_map_name` VALUES (null, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, lawMapName.getName());
        statement.execute();
    }

    public List<LawMapName> selectAll() throws SQLException {
        String sql = "SELECT * FROM lawmapsdb.law_map_name";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        return buildList(resultSet);
    }

    public LawMapName select(int id) throws SQLException{
        String sql = "SELECT * FROM lawmapsdb.law_map_name WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        set.next();
        return build(set);
    }

    public void delete (int id) throws SQLException {
        String sql = "DELETE FROM `lawmapsdb`.`law_map_name` WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
    }

    public void updateName (String value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`law_map_name` SET `name` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, value);
        statement.setInt(2, id);
        statement.execute();
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
