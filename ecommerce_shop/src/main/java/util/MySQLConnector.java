package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
    private static final String DB_ADDRESS = "jdbc:mysql://localhost/web_project";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(MYSQL_DRIVER);
            return DriverManager.getConnection(DB_ADDRESS, USER, PASSWORD);
        } catch (SQLException e) {
            // todo: add logging
            throw new RuntimeException("connection broken", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
