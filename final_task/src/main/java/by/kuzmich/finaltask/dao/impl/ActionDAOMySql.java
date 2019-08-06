package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.Action;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.dao.DAOMySQL;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.exception.ExceptionMessageList;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActionDAOMySql extends  DAOMySQL<Action, Action> {
    private final String INSTRUCTIONS = "instructions";
    private final String USER_ID = "user_id";
    public ActionDAOMySql(Connection connection) {
        super(
                connection,
                "INSERT INTO `lawmapsdb`.`action` VALUES (null, ?, ?, ?)",
                "SELECT * FROM lawmapsdb.action",
                "SELECT * FROM lawmapsdb.action WHERE id = ?",
                "DELETE FROM `lawmapsdb`.`action` WHERE id = ?",
                "UPDATE `lawmapsdb`.`action` SET `name` = ?, `instructions` = ?, `user_id` = ? WHERE `id` = ?"
        );
    }

    @Override
    protected void prepareStatementInsert(PreparedStatement statement, Action action) throws SQLException {
        statement.setString(1, action.getName());
        statement.setString(2, action.getInstructions());
        statement.setInt(3, action.getUser().getId());
    }

    @Override
    protected void prepareStatementUpdate(PreparedStatement statement, Action action) throws SQLException {
        prepareStatementInsert(statement, action);
        statement.setInt(4, action.getId());
    }

    protected Action build(ResultSet set) throws SQLException {
        int id = set.getInt(super.ID);
        String name = set.getString(super.NAME);
        String instructions = set.getString(INSTRUCTIONS);
        int userId = set.getInt(USER_ID);
        return new Action(id, name,instructions,null, new User(userId));
    }

    @Override
    protected Action prepareSelectResult(ResultSet set) throws SQLException {
        set.next();
        return build(set);
    }
}
