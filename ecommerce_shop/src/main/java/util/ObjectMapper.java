package util;

import dao.annotation.Column;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class ObjectMapper {

    private Class<?> clazz;

    public ObjectMapper(Class<?> clazz) {
        this.clazz = clazz;
    }

    public <T> T mapResultSetToObject(ResultSet resultSet) throws SQLException {
        Map<String, Object> fromRs = new LinkedHashMap<>();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        Map<String, Field> fields = new HashMap<>();
        Object instance;
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            fromRs.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
        }
        List<Field> fieldList = Arrays.asList(clazz.getDeclaredFields());
        for (Field field : fieldList) {
            Column col = field.getAnnotation(Column.class);
            if (col != null) {
                field.setAccessible(true);
                fields.put(col.name(), field);
            }
        }
        try {
            instance = clazz.getConstructor().newInstance();
            for (Map.Entry<String, Object> entity : fromRs.entrySet()) {
                if (entity.getValue() == null) {
                    continue;
                }
                String column = entity.getKey();
                Field field = fields.get(column);
                if (field != null) {
                    field.set(instance, entity.getValue());
                }
            }
            return (T) instance;

        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            //
        }
        return null;
    }
}
