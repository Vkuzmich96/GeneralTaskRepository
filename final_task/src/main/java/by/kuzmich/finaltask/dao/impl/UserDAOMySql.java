package by.kuzmich.finaltask.dao.impl;

import by.kuzmich.finaltask.dao.UserDAO;
import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOMySql implements UserDAO {
    private Connection connection;

    public UserDAOMySql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert (User user) throws SQLException {
        String sql = "INSERT INTO `lawmapsdb`.`users` VALUES (null, ?, ?,?, ?,?,? )";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getPassword());
        statement.setInt(3, user.getRole().getNumber());
        statement.setString(4, user.getName());
        statement.setString(5, user.getAddress());
        statement.setLong(6, user.getNumber());
        statement.execute();
    }

    @Override
    public List<User> selectAll () throws SQLException {
        String sql = "SELECT * FROM lawmapsdb.users";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        return buildList(resultSet);
    }


    public User select(int id) throws SQLException{
        String sql = "SELECT * FROM lawmapsdb.users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        set.next();
        return build(set);
    }

    public void delete (int id) throws SQLException {
        String sql = "DELETE FROM `lawmapsdb`.`users` WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
    }

    public void updateEmail (String value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`users` SET `email` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, value);
        statement.setInt(2, id);
        statement.execute();
    }

    public void updatePassword (String value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`users` SET `password` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, value);
        statement.setInt(2, id);
        statement.execute();
    }

    public void updateRole (int value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`users` SET `role` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, value);
        statement.setInt(2, id);
        statement.execute();
    }

    public void updateName (String value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`users` SET `name` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, value);
        statement.setInt(2, id);
        statement.execute();
    }

    public void updateAddress (String value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`users` SET `address` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, value);
        statement.setInt(2, id);
        statement.execute();
    }

    public void updatePhone (Long value, int id) throws SQLException {
        String sql = "UPDATE `lawmapsdb`.`users` SET `phone` = ? WHERE `id` = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, value);
        statement.setInt(2, id);
        statement.execute();
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
