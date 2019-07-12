package by.kuzmich.finaltask;

import by.kuzmich.finaltask.DAO.impl.UserDAOMySql;
import by.kuzmich.finaltask.bean.User;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    private static UserDAOMySql dao = new UserDAOMySql();
    public static void main(String[] args) {
        try {
            List<User> users = dao.selectAll();
            System.out.println(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//    User user = new User("11","11", Role.USER,"11","1",11);
//        try {
//                dao.insert(user);
//                } catch (SQLException e) {
//                e.printStackTrace();
//                }