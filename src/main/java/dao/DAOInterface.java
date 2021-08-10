package dao;

import java.util.List;

public interface DAOInterface<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    T findById(int id);
    List<T> findAll();
}
