package dao;

import util.MySQLConnector;
import util.ObjectMapper;
import util.QueryUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AbstractDao<T, ID> implements GenericDao<T, ID> {

    private final Connection connection;
    private final Map<String, String> queries;
    private final ObjectMapper mapper;

    public AbstractDao(Class<?> clazz) {
        this.connection = MySQLConnector.getConnection();
        queries = QueryUtil.generateQueries(clazz);
        mapper = new ObjectMapper(clazz);
    }

    @Override
    public T create(T t) {
        String createQuery = queries.get("create");
        List<String> vaules = getListOfValues(t);
        try (PreparedStatement statement
                     = connection.prepareStatement(createQuery)) {
            for (int i = 0; i < vaules.size(); i++) {
                statement.setObject(i + 1, vaules.get(i));
            }
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return t;
    }

    public List<String> getListOfValues(T t) {
        StringBuilder result = new StringBuilder();
        Field f;
        Field[] fields;
        try {
            fields = t.getClass().getDeclaredFields();
            for (Field field : fields) {
                f = field;
                f.setAccessible(true);
                result.append(f.get(t).toString()).append(",");
            }
        } catch (Exception ignored) {
        }
        return Stream.of
                        (result.toString().split(",", -1))
                .filter(s -> !s.isBlank())
                .collect(Collectors.toList());
    }

    @Override
    public T read(ID id) {
        String readQuery = queries.get("read");
        try (PreparedStatement statement
                     = connection.prepareStatement(readQuery)) {
            statement.setObject(1, id);
            return mapper.mapResultSetToObject(statement.executeQuery());
        } catch (SQLException throwables) {
            // add logger here
        }
        return null;
    }

    @Override
    public T update(T t) {
        String updateQuery = queries.get("update");
        try (PreparedStatement statement
                     = connection.prepareStatement(updateQuery)) {
            statement.execute();
        } catch (SQLException throwables) {
            // add logger here
        }
        return t;
    }

    @Override
    public void delete(ID id) {
        String deleteQuery = queries.get("delete");
        try (PreparedStatement statement
                     = connection.prepareStatement(deleteQuery)) {
            statement.execute();
        } catch (SQLException throwables) {
            // add logger here
        }
    }

    @Override
    public List<T> readAll() {
        List<T> list = new ArrayList<>();
        String readAllQuery = queries.get("readAll");
        try (PreparedStatement statement
                     = connection.prepareStatement(readAllQuery)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(mapper.mapResultSetToObject(resultSet));
            }
        } catch (SQLException throwables) {
            // add logger here
        }
        return list;
    }
}
