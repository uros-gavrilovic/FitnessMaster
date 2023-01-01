package repo;

import java.util.ArrayList;
import java.util.List;

public interface Repository<T> {
    void insert(T param) throws Exception;
    void update(T param) throws Exception;
    void delete(T param) throws Exception;
    T find(int id) throws Exception;
    ArrayList<T> getAll();
}
