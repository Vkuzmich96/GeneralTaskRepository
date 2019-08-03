package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.Material;
import by.kuzmich.finaltask.dao.DAOMySQL;

import java.sql.*;



public class MaterialDAOMySql extends DAOMySQL <Material, Material> {
    private final int URL_INDEX = 1;
    private final int DESCRIPTION_INDEX = 2;
    private final int NAME_INDEX = 3;
    private final int ID_FOR_UPDATE = 4;
    private final String URL = "url";
    private final String DESCRIPTION = "discription";

    public MaterialDAOMySql(Connection connection) {
        super(connection,
                "INSERT INTO `lawmapsdb`.`materials` VALUES (null, ?, ?, ?)",
                "SELECT * FROM lawmapsdb.materials",
                "SELECT * FROM lawmapsdb.materials WHERE id = ?",
                "DELETE FROM `lawmapsdb`.`materials` WHERE id = ?",
                "UPDATE `lawmapsdb`.`materials` SET `url` = ?, `discription` = ?, `name` = ? WHERE `id` = ?"
        );
    }

    @Override
    protected void prepareStatementInsert(PreparedStatement statement, Material material) throws SQLException {
        statement.setString(URL_INDEX, material.getUrl());
        statement.setString(DESCRIPTION_INDEX, material.getDiscription());
        statement.setString(NAME_INDEX, material.getName());
    }

    @Override
    protected void prepareStatementUpdate(PreparedStatement statement, Material material) throws SQLException {
        prepareStatementInsert(statement, material);
        statement.setInt(ID_FOR_UPDATE, material.getId());
    }

    protected Material build(ResultSet set) throws SQLException {
        int id = set.getInt(super.ID);
        String url = set.getString(URL);
        String description = set.getString(DESCRIPTION);
        String name = set.getString(super.NAME);
        return new Material(id,url,description, name);
    }

    @Override
    protected Material buildToSelect(ResultSet set) throws SQLException {
        set.next();
        return build(set);
    }
}
