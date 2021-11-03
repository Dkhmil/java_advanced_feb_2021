package repository;

import java.util.List;

public interface AbstractCrudOperations<T> {

    List<T> readAll();

    T read(int id);

    void create(T t);

    void update(T t, String property, String newValue);

    void delete(int id);
}
