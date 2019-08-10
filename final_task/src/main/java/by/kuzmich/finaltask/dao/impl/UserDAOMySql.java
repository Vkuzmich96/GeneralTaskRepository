package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.DAOMySQL;
import by.kuzmich.finaltask.exception.DAOException;
import by.kuzmich.finaltask.exception.ExceptionMessageList;
import org.apache.log4j.Logger;

import java.sql.*;

public class UserDAOMySql extends DAOMySQL<User, User> {
    private static Logger logger = Logger.getLogger(UserDAOMySql.class);
    private Connection connection;
    private final String SELECT = "SELECT * FROM lawmapsdb.users WHERE email = ?";
    private final String EMAIL ="email";
    private final String PASSWORD = "password";
    private final String ROLE = "role";
    private final String ADDRESS = "address";
    private final String PHONE = "phone";
    public UserDAOMySql(Connection connection) {
        super(connection,
             "INSERT INTO `lawmapsdb`.`users` VALUES (null, ?, ?,?, ?,?,? )",
             "SELECT * FROM lawmapsdb.users",
             "",
             "DELETE FROM `lawmapsdb`.`users` WHERE id = ?",
             "UPDATE `lawmapsdb`.`users` SET `email` = ?, `password` = ?, `role` = ?, `name` = ?, `address` = ?, `phone` = ? WHERE `id` = ?"
        );
        this.connection = connection;
    }


    public User select(String email) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            statement.setString(1, email);
            ResultSet set = statement.executeQuery();
            if(set.next()) {
                return build(set);
            }
            return new User();
        } catch (SQLException e){
            logger.error(ExceptionMessageList.UNABLE_TO_SELECT);
            throw new DAOException(ExceptionMessageList.UNABLE_TO_SELECT);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(ExceptionMessageList.UNABLE_TO_CLOSE);
            }
        }
    }

    @Override
    protected void prepareStatementInsert(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getPassword());
        statement.setInt(3, user.getRole().getNumber());
        statement.setString(4, user.getName());
        statement.setString(5, user.getAddress());
        statement.setLong(6, user.getNumber());
    }

    @Override
    protected void prepareStatementUpdate(PreparedStatement statement, User user) throws SQLException {
        prepareStatementInsert(statement, user);
        statement.setInt(7, user.getId());
    }


    protected User build (ResultSet set) throws SQLException {
        int id = set.getInt(super.ID);
        String email = set.getString(EMAIL);
        String password = set.getString(PASSWORD);
        int roleNumber = set.getInt(ROLE);
        Role role = choseRole(roleNumber);
        String name = set.getString(super.NAME);
        String address = set.getString(ADDRESS);
        long phone = set.getLong(PHONE);
        return new User(id,email,password,role,name,address,phone);
    }

    @Override
    protected User prepareSelectResult(ResultSet set) throws SQLException {
        return build(set);
    }

    private Role choseRole (int number){
        switch (number){
            default :
                return Role.USER;
            case 1 :
                return Role.ADMIN;
            case 2 :
                return Role.LAWER;
        }
    }
}
