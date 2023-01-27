package repo;

import domain.GenericEntity;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

public interface Repository<GenericEntity> {
    void insert(GenericEntity entity) throws Exception;
    void update(GenericEntity entity) throws Exception;
    void delete(GenericEntity entity) throws Exception;
    ResultSet find(GenericEntity entity) throws Exception;
    ArrayList<ResultSet> getAll(GenericEntity entity) throws Exception;
}
