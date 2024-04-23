package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.StatementWrapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

}
