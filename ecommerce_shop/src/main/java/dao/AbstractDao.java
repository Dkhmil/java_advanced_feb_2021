package dao;

import util.MySQLConnector;
import util.ObjectMapper;
import util.QueryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        try (PreparedStatement statement
                     = connection.prepareStatement(createQuery)) {
            statement.execute();
        } catch (SQLException throwables) {
            // add logger here
        }
        return t;
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
