package repository;

import java.util.List;

public interface AbstractCrudOperations<T> {

    List<T> readAll();

    T read(int id);

    void create(T t);

    void update(T t);

    void delete(int id);
}
