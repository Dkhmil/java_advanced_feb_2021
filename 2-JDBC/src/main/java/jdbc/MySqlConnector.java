package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {

    private static final String URL = "jdbc:mysql://localhost/web";

    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
       // Class.forName(MYSQL_DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
