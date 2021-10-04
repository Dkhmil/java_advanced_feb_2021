package util;

import dao.annotation.Column;
import dao.annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class QueryUtil {

    public static Map<String, String> generateQueries(Class<?> clazz) {
        return QueryUtil.queryBuilder(clazz);
    }

    private static Map<String, String> queryBuilder(Class<?> clazz) {
        Map<String, String> map = new LinkedHashMap<>();
        String[] result = new String[0];
        try {
            result = getDataFromClazz(clazz);
        } catch (IllegalAccessException e) {
            //
        }
        String read = "SELECT " + result[0] + " FROM " + result[2] + " WHERE ID = ?";
        String create = "INSERT INTO " + result[2] + "(" + result[0] + ") VALUES(" + result[1] + ");";
        String update = "UPDATE " + result[2] + " SET " + result[3] + " WHERE ID =" + result[3].substring(5, result[3].indexOf(","));
        String delete = "DELETE FROM " + result[2] + " WHERE ID = ?";
        String findAll = "SELECT " + result[0] + " FROM " + result[2] + ";";

        map.put("read", read);
        map.put("create", create);
        map.put("update", update);
        map.put("delete", delete);
        map.put("readAll", findAll);
        return map;
    }


    private static String[] getDataFromClazz(Class<?> clazz) throws IllegalAccessException {
        Object object = null;
        try {
            object = clazz.getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            //
        }
        String tableName = clazz.getAnnotation(Table.class).name();
        Field[] localFields = clazz.getDeclaredFields();
        Map<String, Object> fields = new LinkedHashMap<>();
        Map<String, Object> types = new LinkedHashMap<>();

        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        StringBuilder update = new StringBuilder();
        for (Field field : localFields) {
            String column = field.getAnnotation(Column.class).name();
            if (column != null) {
                Object value;
                Object type;
                field.setAccessible(true);
                value = field.get(object);
                type = field.getType().getSimpleName();
                fields.put(column, value);
                types.put(column, type);
            }
        }
        for (String key : fields.keySet()) {
            columns.append(key);
            if (columns.length() > 1) {
                columns.append(",");
            }
        }
        columns = columns.deleteCharAt(columns.length() - 1);
        for (Object value : fields.values()) {
            values.append("'" + value + "'");
            if (values.length() >= 1) {
                values.append(",");
            }
        }
        values = values.deleteCharAt(values.length() - 1);

        for (Map.Entry<String, Object> entity : fields.entrySet()) {
            update.append(entity.getKey() + " = '");
            update.append(entity.getValue() + "',");
        }
        update = update.deleteCharAt(update.length() - 1);

        String[] result = new String[4];
        result[0] = columns.toString();
        result[1] = values.toString();
        result[2] = tableName;
        result[3] = update.toString();
        return result;
    }
}
