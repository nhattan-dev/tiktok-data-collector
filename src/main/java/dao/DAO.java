package dao;

import java.util.List;

public interface DAO<T> {
    public void save(T t);
    public void save(List<T> ts);
}
