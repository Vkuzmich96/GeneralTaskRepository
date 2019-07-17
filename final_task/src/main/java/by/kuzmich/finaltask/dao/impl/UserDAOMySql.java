package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.DAO;
import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;
import by.kuzmich.finaltask.dao.pool.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOMySql implements DAO<User, User> {
    private static Logger logger = Logger.getLogger(ConnectionPool.class);
    private Connection connection;

    public UserDAOMySql(Connection connection) {
        this.connection = connection;
    }

    //todo ключ кидает ошибку
    @Override
    public int insert (User user) throws SQLException {
        int id = 0;
        try {
            String sql = "INSERT INTO `lawmapsdb`.`users` VALUES (null, ?, ?,?, ?,?,? )";
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, user);
            statement.execute();
//            ResultSet set = statement.getGeneratedKeys();
//            id = set.getInt("id");
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
    public List<User> selectAll () throws SQLException {
        List<User> users = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.users";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            users = buildList(resultSet);
        } catch (SQLException e){
            logger.error("its impossible to select data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
        return users;
    }


    public User select(String email) throws SQLException{
        User user = null;
        try {
            String sql = "SELECT * FROM lawmapsdb.users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet set = statement.executeQuery();
            set.next();
            user = build(set);
        } catch (SQLException e){
            logger.error("its impossible to select data");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("its impossible to close connection");
            }
        }
        return user;
    }

    public void delete (int id) throws SQLException {
        try {
            String sql = "DELETE FROM `lawmapsdb`.`users` WHERE id = ?";
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


    public void update(User user){
        try {
            String sql = "UPDATE `lawmapsdb`.`users` SET `email` = ?, `password` = ?, `role` = ?, `name` = ?, `address` = ?, `phone` = ? WHERE `id` = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            prepareStatement(statement, user);
            statement.setInt(7, user.getId());
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

    private void prepareStatement(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getPassword());
        statement.setInt(3, user.getRole().getNumber());
        statement.setString(4, user.getName());
        statement.setString(5, user.getAddress());
        statement.setLong(6, user.getNumber());
    }

    private List<User> buildList (ResultSet set) throws SQLException {
        List<User> users = new ArrayList<>();
        while (set.next()){
            User user = build(set);
            users.add(user);
        }
        return users;
    }

    private User build (ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String email = set.getString("email");
        String password = set.getString("password");
        int roleNumber = set.getInt("role");
        Role role = choseRole(roleNumber);
        String name = set.getString("name");
        String address = set.getString("address");
        long phone = set.getLong("phone");
        return new User(id,email,password,role,name,address,phone);
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
