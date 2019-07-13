package by.kuzmich.finaltask.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static String url = "jdbc:mysql://localhost/lawmapsdb?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String pass = "root";

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
