package service.imp;

import dao.User;
import jdbc.MySqlConnector;
import service.UserService;

import javax.swing.plaf.metal.DefaultMetalTheme;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static Connection connection;

    static {
        try {
            connection = MySqlConnector.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createUser(User user) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO web.users (id, name) VALUES (?, ?)")) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.execute();
        }
    }

    public void getMetaData() throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getSchemas();
        ResultSet rs2 = databaseMetaData.getTables("web",  "","%", null);
        while (rs2.next()) {
           String s = (String) rs2.getObject(3);
            System.out.println(s);
        }

    }
}
