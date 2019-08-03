package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.LawMapName;
import by.kuzmich.finaltask.dao.DAOMySQL;

import java.sql.*;

public class LawMapNameDAOMySql extends DAOMySQL<LawMapName, LawMapName> {
    private final String READINESS = "readiness";
    private final int NAME_INDEX = 1;
    private final int READINESS_INDEX = 2;
    private final int ID_INDEX = 3;
    private final int TRUE_FLAG = 1;
    private final int FALSE_FLAG = 0;


    public LawMapNameDAOMySql(Connection connection) {
        super(connection,
                "INSERT INTO `lawmapsdb`.`law_map_name` VALUES (null, ?, ?)",
                "SELECT * FROM lawmapsdb.law_map_name",
                "SELECT * FROM lawmapsdb.law_map_name WHERE id = ?",
                "DELETE FROM `lawmapsdb`.`law_map_name` WHERE id = ?",
                "UPDATE `lawmapsdb`.`law_map_name` SET `name` = ?, `readiness` = ?  WHERE `id` = ?"
        );
    }

    @Override
    protected void prepareStatementInsert(PreparedStatement statement, LawMapName name) throws SQLException {
        statement.setString(NAME_INDEX, name.getName());
        statement.setInt(READINESS_INDEX, name.getReadiness() ? TRUE_FLAG : FALSE_FLAG);
    }

    @Override
    protected void prepareStatementUpdate(PreparedStatement statement, LawMapName name) throws SQLException {
        prepareStatementInsert(statement, name);
        statement.setInt(ID_INDEX, name.getId());
    }

    protected LawMapName build(ResultSet set) throws SQLException {
        int id = set.getInt(super.ID);
        String name = set.getString(super.NAME);
        boolean readiness = set.getInt(READINESS) == TRUE_FLAG;
        return new LawMapName(id, name, readiness);
    }

    @Override
    protected LawMapName buildToSelect(ResultSet set) throws SQLException {
        set.next();
        return build(set);
    }
}
