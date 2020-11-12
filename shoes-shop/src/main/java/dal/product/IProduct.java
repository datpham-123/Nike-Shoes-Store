package dal.product;

import java.util.List;

public interface IProduct<T> {

    public List<T> getAll();
    public T getOneByID(int id);
    public boolean add(T item);
    public boolean update(T item, int id);
    public boolean delete(int id);
}
