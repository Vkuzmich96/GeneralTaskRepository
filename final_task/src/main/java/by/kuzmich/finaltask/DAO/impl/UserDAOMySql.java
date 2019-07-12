package by.kuzmich.finaltask.DAO.impl;

import by.kuzmich.finaltask.DAO.UserDAO;
import by.kuzmich.finaltask.DAO.utils.MySQLConnection;
import by.kuzmich.finaltask.bean.Role;
import by.kuzmich.finaltask.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOMySql implements UserDAO {
    private Connection connection = MySQLConnection.getConnection();

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

    public List<User> selectAll () throws SQLException {
        String sql = "SELECT * FROM lawmapsdb.users";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        return buildUserList(resultSet);
}

    private List<User> buildUserList (ResultSet set) throws SQLException {
        List<User> users = new ArrayList<>();
        while (set.next()){
            User user = buildUser(set);
            users.add(user);
        }
        return users;
    }

    private User buildUser (ResultSet set) throws SQLException {
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
