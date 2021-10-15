package dao;

import lombok.SneakyThrows;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl extends AbstractDao<User, Long> {


    public UserDaoImpl(Class<?> clazz) {
        super(clazz);
    }

    @SneakyThrows
    public User findUserByEmail(String email) {
        User user;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE USER_EMAIL = ?")) {
            statement.setString(1, email);
            user = mapper.mapResultSetToObject(statement.executeQuery());
        }
        return user;
    }
}
