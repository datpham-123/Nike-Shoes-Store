package dal;

import java.util.List;

public interface IDAO<T> {

    public List<T> getAll();
    public T getOneByID(int id);
    public boolean add(T item);
    public boolean update(T item, int id);
    public boolean delete(int id);
}
