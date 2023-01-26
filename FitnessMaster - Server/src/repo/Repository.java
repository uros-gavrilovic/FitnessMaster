package repo;

import domain.GenericEntity;
import java.util.ArrayList;
import java.util.List;

public interface Repository {
    void insert(GenericEntity param) throws Exception;
    void update(GenericEntity param) throws Exception;
    void delete(GenericEntity param) throws Exception;
//    T find(int id) throws Exception;
//    ArrayList<T> getAll();
    GenericEntity find(GenericEntity param) throws Exception;
    ArrayList<GenericEntity> getAll(GenericEntity param);
}
