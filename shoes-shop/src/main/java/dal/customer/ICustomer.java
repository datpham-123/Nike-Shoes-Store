package dal.customer;

import java.util.List;

public interface ICustomer<T> {

    public List<T> getAll();
    public T getOne(int id);
    public boolean add(T item);
    public boolean update(T item, int id);
    public boolean delete(int id);
    public boolean checkRegister(String username);
}
