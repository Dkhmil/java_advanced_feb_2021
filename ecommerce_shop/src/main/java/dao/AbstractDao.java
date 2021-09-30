package dao;

import util.MySQLConnector;
import util.QueryUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class AbstractDao<T, ID> implements GenericDao<T, ID>{

    private Class<?> clazz;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private QueryUtil queryUtil;

    public AbstractDao(Class<?> clazz) {
        this.clazz = clazz;
        this.connection = MySQLConnector.getConnection();
    }

    @Override
    public T create(T t) {
        String createQuery = QueryUtil.CREATE_QUERY;
        return connection.createStatement().execute(createQuery);
    }

    @Override
    public T read(ID id) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public void delete(ID id) {

    }

    @Override
    public List<T> readAll() {
        return null;
    }
}
